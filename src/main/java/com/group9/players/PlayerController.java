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
   
    /**
     * Get list of all players, sort them by ID and forward them to allPlayers JSP
     * @param model
     * @param principal
     * @return 
     */
    @GetMapping("players")
    public String listPlayers(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        List<Player> players = service.findAllPlayers();
        
        Collections.sort(players, new PlayerComparator());
        model.addAttribute("players", players);
        return "allplayers";
    }
    /**
     * List all players, sort them but display them for in admin jsp
     * @param model
     * @param principal
     * @return 
     */
    @GetMapping("admin/players")
    public String listAdminPlayers(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        List<Player> players = service.findAllPlayers();
        
        Collections.sort(players, new PlayerComparator());
        model.addAttribute("players", players);
        return "adminplayers";
    }
    
    /**
     * Get Details of specific player
     * @param model
     * @param id
     * @param principal
     * @return 
     */
    @GetMapping("player/{id}")
    public String getPlayer(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        Player player = service.findById(id);
        model.addAttribute("player", player);
        return "viewplayer";
    }
    /**
     * Reroll a player to a brand new (generated) one
     * @param model
     * @param id
     * @param principal
     * @return 
     */
    @GetMapping("players/{id}/switch/")
    public String switchPlayer(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        //Check security levels of user
        if(SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
                try {
                    //Find current player
                    Player player = service.findById(id);
                    //Find current user
                    User u = userJDBCTemplate.getUser(principal.getName());
                    //Is the player owned by this user?
                    if(GenericHelper.isPlayerInList(service.getPlayers(u), player)){
                        //Does the user have enough money?
                        if(u.getBudget() > Registry.lootBoxPrice){
                            //Lower his budget
                            u.setBudget(u.getBudget()-Registry.lootBoxPrice);
                            userJDBCTemplate.updateBudget(u.getUsername(), u.getBudget());
                            
                            //Update team
                            Team t = teamService.findByName(u.getTeamName());
                            
                            Player newPlayer = service.generateRandomPlayers(1).get(0);
                            newPlayer.setInTeam(1);
                            service.updatePlayer(newPlayer);
                            
                            player.setInTeam(0);
                            service.updatePlayer(player);
                            //Find the right position of the player
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
                            //Update team DB
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
    /**
     * Display upgrades for specific player
     * @param model
     * @param id
     * @param principal
     * @return 
     */
    @GetMapping("/players/{id}/upgrade/")
    public String getPlayerUpgrade(ModelMap model, @PathVariable int id, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        Player playerout = service.findById(id);
        model.addAttribute("player", playerout);
        //Calculate cost
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
    
    /**
     * Handle upgrade post request for player
     * @param type
     * @param id
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = { "/players/{id}/upgrade/" }, method = RequestMethod.POST)
    public String upgradePlayer(@RequestParam String type, @PathVariable int id, 
            ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        //Check player security levels
        if(SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
            try {
                //Get player
                Player player = service.findById(id);
                int ugpradeLevel = 0;
                //Select if we want to upgrade def or off
                if(type.contentEquals("def")){
                    ugpradeLevel = player.getDefense();
                    player.setDefense(Math.min(99, player.getDefense()+3));
                    
                } else if(type.contentEquals("off")){
                    ugpradeLevel = player.getOffense();
                    player.setOffense(Math.min(99, player.getOffense()+3));
                }

                //Get User
                User user = userJDBCTemplate.getUser(principal.getName());
                
                
                model.addAttribute("budget", user.getBudget());
                
                //Update budget and cost
                int cost = GenericHelper.calculateCost(ugpradeLevel);
                if(user != null && user.getBudget() > cost){
                    if(GenericHelper.isPlayerInList(service.getPlayers(user), player)){
                        //Update player
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
        //Display new player stats
        Player playerout = service.findById(id);
        model.addAttribute("player", playerout);
        
        model.addAttribute("pricedef", GenericHelper.calculateCost(playerout.getDefense()));
        model.addAttribute("priceoff", GenericHelper.calculateCost(playerout.getOffense()));
        return "upgradeplayer";
      

    }
    /**
     * REST update of player
     * @param model
     * @param id
     * @param principal
     * @return 
     */
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
    /**
     * Handle post request of player update, propagate this change to the db
     * @param player
     * @param result
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = { "/player/{id}/update" }, method = RequestMethod.POST)
    public String updatePOSTPlayer(@Valid Player player, BindingResult result,
            ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        if (result.hasErrors()) {
            return "reg_player";
        }
 
       
        if(!service.isPlayerIDUnique(player.getId())){
            FieldError idError = new FieldError("player","id",messageSource.getMessage("non.unique.id", new Integer[]{player.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "reg_player";
        }
         
        service.updatePlayer(player);
        
        model.addAttribute("message", "Player " + player.getForename()+ " updated successfully");
        return "reg_player";
    }
    
    /**
     * Get registry page for a new user
     * @param model
     * @param principal
     * @return 
     */
    @GetMapping("/player/new")
    public String newPlayer(ModelMap model, Principal principal) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        Player player = new Player();
        model.addAttribute("player", player);
        model.addAttribute("edit", false);
        return "reg_player";
    }
 
    
   /**
    * Handle new user post request
    * @param player
    * @param result
    * @param model
    * @param principal
    * @return 
    */
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
 
 
    
     
    
   
    /**
     * Delete user via service
     * @param id
     * @param principal
     * @param model
     * @return 
     */
    @RequestMapping(value="player/delete", method=RequestMethod.POST)
    public String deleteUser(@RequestParam int id, Principal principal, ModelMap model) {
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        service.deletePlayerById(id);
        return "redirect:/admin/players";
    }
    
    /**
     * Generate random X number of players
     * @param number
     * @param model
     * @param principal
     * @return 
     */
    @RequestMapping(value = { "/admin/random/{number}" }, method = RequestMethod.GET)
       public String generatePlayer(@PathVariable int number, ModelMap model, Principal principal) {
           
           GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);

           service.generateRandomPlayers(number);
           
           //model.addAttribute("success", "Employee " + player.getForename()+ " registered successfully");
           return "redirect:players";
       }
}

