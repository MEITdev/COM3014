/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;


import com.group9.teams.Team;
import com.group9.teams.TeamService;
import com.group9.exceptions.UserNotFoundException;
import com.group9.generic.GenericHelper;
import com.group9.generic.Registry;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
 

 
@Controller
@RequestMapping("/")
public class PlayerController {
 
    @Autowired
    PlayerService service;
    
    @Autowired
    TeamService teamService;
     
    @Autowired
    MessageSource messageSource;
 
      @Autowired
    private UserJDBCTemplate userJDBCTemplate;
   
    @GetMapping("players")
    public String listPlayers(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        List<Player> players = service.findAllPlayers();
        
        Collections.sort(players, new PlayerComparator());
        model.addAttribute("players", players);
        return "allplayers";
    }
    
    @GetMapping("admin/players")
    public String listAdminPlayers(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        List<Player> players = service.findAllPlayers();
        
        Collections.sort(players, new PlayerComparator());
        model.addAttribute("players", players);
        return "adminplayers";
    }
    
    @GetMapping("player/{id}")
    public String getPlayer(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        Player player = service.findById(id);
        model.addAttribute("player", player);
        return "viewplayer";
    }
    
    @GetMapping("players/{id}/switch/")
    public String switchPlayer(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        if(SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
                try {
                    
                    Player player = service.findById(id);
                    
                    User u = userJDBCTemplate.getUser(principal.getName());
                    if(GenericHelper.isPlayerInList(service.getPlayers(u), player)){
                        if(u.getBudget() > Registry.lootBoxPrice){
                            u.setBudget(u.getBudget()-Registry.lootBoxPrice);
                            userJDBCTemplate.updateBudget(u.getUsername(), u.getBudget());
                            
                            Team t = teamService.findByName(u.getTeamName());
                            
                            Player newPlayer = service.generateRandomPlayers(1).get(0);
                            newPlayer.setInTeam(1);
                            service.updatePlayer(newPlayer);
                            
                            player.setInTeam(0);
                            service.updatePlayer(player);
                            
                            if(t.getPlayer1ID() == id){
                                t.setPlayer1ID(newPlayer.getId());
                            }else if(t.getPlayer2ID() == id){
                                t.setPlayer2ID(newPlayer.getId());
                            }else if(t.getPlayer3ID() == id){
                                t.setPlayer3ID(newPlayer.getId());
                            }else if(t.getPlayer4ID() == id){
                                t.setPlayer4ID(newPlayer.getId());
                            }else if(t.getPlayer5ID() == id){
                                t.setPlayer5ID(newPlayer.getId());
                            }else if(t.getPlayer6ID() == id){
                                t.setPlayer6ID(newPlayer.getId());
                            }
                            teamService.updatePostTeam(t);
                            model.put("message", "Congratulations! You have bought a lootpack!");
                        }else{
                            model.put("message", "Please do not cheat, you do not have enough money");
                        }
                        
                    }else{
                        model.put("message", "Please do not cheat, you can only edit players you own");
                    }
                    

                } catch (UserNotFoundException ex) {
                    Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
        
        return "redirect:/team";
    }
    
    //UPGRADES
    @GetMapping("/players/{id}/upgrade/")
    public String getPlayerUpgrade(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        Player playerout = service.findById(id);
        model.addAttribute("player", playerout);
        model.addAttribute("pricedef", GenericHelper.calculateCost(playerout.getDefense()));
        model.addAttribute("priceoff", GenericHelper.calculateCost(playerout.getOffense()));
        
        
        User user;
        try {
            user = userJDBCTemplate.getUser(principal.getName());
            model.addAttribute("budget", user.getBudget());
        } catch (UserNotFoundException ex) {
            Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "upgradeplayer";
      
    }
    
    //Switch
    
    
    @RequestMapping(value = { "/players/{id}/upgrade/" }, method = RequestMethod.POST)
    public String upgradePlayer(@RequestParam String type, @PathVariable int id, 
            ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        if(SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
            try {
                Player player = service.findById(id);
                int ugpradeLevel = 0;
                
                if(type.contentEquals("def")){
                    ugpradeLevel = player.getDefense();
                    player.setDefense(Math.min(99, player.getDefense()+3));
                    
                } else if(type.contentEquals("off")){
                    ugpradeLevel = player.getOffense();
                    player.setOffense(Math.min(99, player.getOffense()+3));
                }


                User user = userJDBCTemplate.getUser(principal.getName());
                
                
                model.addAttribute("budget", user.getBudget());
                
                
                int cost = GenericHelper.calculateCost(ugpradeLevel);
                if(user != null && user.getBudget() > cost){
                    if(GenericHelper.isPlayerInList(service.getPlayers(user), player)){
                        userJDBCTemplate.updateBudget(user.getUsername(), user.getBudget()-cost);
                        service.updatePlayer(player);
                        model.put("message", "Player has been upgraded");
                    }else{
                        //PLAYER WANTS TO CHEAT and edit user he does not own
                        model.put("message", "Please do not cheat, you can only edit players you own");
                    }
                
                }else{
                    //Either user does not exist or does not have enough cash
                    if(user == null){
                        model.put("message", "User could not be found");
                    }else{
                        model.put("message", "You do not have enough budget to upgrade this player");
                    }
                }
            } catch (UserNotFoundException ex) {
                Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        Player playerout = service.findById(id);
        model.addAttribute("player", playerout);
        
        model.addAttribute("pricedef", GenericHelper.calculateCost(playerout.getDefense()));
        model.addAttribute("priceoff", GenericHelper.calculateCost(playerout.getOffense()));
        return "upgradeplayer";
      

    }
 
    @GetMapping("player/{id}/update")
    public String getPlayerUpdate(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        Player player = service.findById(id);
        if(player == null){
            return "redirect:/admin/players";
        }
        
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        return "reg_player";
    }
    
    @RequestMapping(value = { "/player/{id}/update" }, method = RequestMethod.POST)
    public String updatePOSTPlayer(@Valid Player player, BindingResult result,
            ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
 
        if (result.hasErrors()) {
            return "reg_player";
        }
 
       
        if(!service.isPlayerIDUnique(player.getId())){
            FieldError idError = new FieldError("player","id",messageSource.getMessage("non.unique.id", new Integer[]{player.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "reg_player";
        }
         
        service.updatePlayer(player);
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        model.addAttribute("message", "Player " + player.getForename()+ " updated successfully");
        return "reg_player";
    }
    
    @GetMapping("/player/new")
    public String newPlayer(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        Player player = new Player();
        model.addAttribute("player", player);
        model.addAttribute("edit", false);
        return "reg_player";
    }
 
    
   
    @RequestMapping(value = { "/player/new" }, method = RequestMethod.POST)
    public String savePlayer(@Valid Player player, BindingResult result,
            ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
 
        if (result.hasErrors()) {
            return "reg_player";
        }
 
       
        if(!service.isPlayerIDUnique(player.getId())){
            FieldError idError = new FieldError("player","id",messageSource.getMessage("non.unique.id", new Integer[]{player.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "reg_player";
        }
         
        service.savePlayer(player);
 
        model.addAttribute("message", "Player " + player.getForename()+ " registered successfully");
        return "reg_player";
    }
 
 
    
     
    
   

    @RequestMapping(value="player/delete", method=RequestMethod.POST)
    public String deleteUser(@RequestParam int id, Principal principal, ModelMap model) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        service.deletePlayerById(id);
        return "redirect:/admin/players";
    }
    
    @RequestMapping(value = { "/new/random/{number}" }, method = RequestMethod.GET)
       public String generatePlayer(@PathVariable int number, ModelMap model, Principal principal) {
           
           GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);

           service.generateRandomPlayers(number);
           
           //model.addAttribute("success", "Employee " + player.getForename()+ " registered successfully");
           return "redirect:players";
       }
}
