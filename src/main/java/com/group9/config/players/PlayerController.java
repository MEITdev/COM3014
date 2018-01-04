/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.players;


import com.group9.exceptions.UserNotFoundException;
import com.group9.generic.GenericHelper;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
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
    MessageSource messageSource;
 
      @Autowired
    private UserJDBCTemplate userJDBCTemplate;
   
    @GetMapping("players")
    public String listPlayers(ModelMap model) {
 
        List<Player> players = service.findAllPlayers();
        model.addAttribute("players", players);
        return "allplayers";
    }
    
    @GetMapping("player/{id}")
    public String getPlayer(ModelMap model, @PathVariable int id) {
        Player player = service.findById(id);
        model.addAttribute("player", player);
        return "viewplayer";
    }
    
    //UPGRADES
    @GetMapping("/players/{id}/upgrade/")
    public String getPlayerUpgrade(ModelMap model, @PathVariable int id, Principal principal) {
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
    
    @RequestMapping(value = { "/players/{id}/upgrade/" }, method = RequestMethod.POST)
    public String upgradePlayer(@RequestParam String type, @PathVariable int id, 
            ModelMap model, Principal principal) {
        
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
 
    
    
    @GetMapping("/new")
    public String newPlayer(ModelMap model) {
        Player player = new Player();
        model.addAttribute("player", player);
        model.addAttribute("edit", false);
        return "reg_player";
    }
 
   
    @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
    public String savePlayer(@Valid Player player, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "reg_player";
        }
 
       
        if(!service.isPlayerIDUnique(player.getId())){
            FieldError idError = new FieldError("player","id",messageSource.getMessage("non.unique.id", new Integer[]{player.getId()}, Locale.getDefault()));
            result.addError(idError);
            return "reg_player";
        }
         
        service.savePlayer(player);
 
        model.addAttribute("success", "Employee " + player.getForename()+ " registered successfully");
        return "success";
    }
 
 
    
    @RequestMapping(value = { "/edit-{id}-player" }, method = RequestMethod.GET)
    public String editPlayer(@PathVariable int id, ModelMap model) {
        Player player = service.findById(id);
        model.addAttribute("player", player);
        model.addAttribute("edit", true);
        return "reg_player";
    }
     
    
    @RequestMapping(value = { "/edit-{ssn}-player" }, method = RequestMethod.POST)
    public String updadtePlayer(@Valid Player player, BindingResult result,
            ModelMap model, @PathVariable String ssn) {
 
        if (result.hasErrors()) {
            return "reg_player";
        }
 
        if(!service.isPlayerIDUnique(player.getId())){
            //FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
            //result.addError(ssnError);
            return "reg_player";
        }
 
        service.getUpdatePlayer(player);
 
        model.addAttribute("success", "Employee " + player.getForename()+ " updated successfully");
        return "success";
    }
 
     
    @DeleteMapping("player/delete")
    public String deletePlayer(@RequestParam int id) {
        service.deletePlayerById(id);
        return "redirect:/players";
    }
    
    @RequestMapping(value = { "/new/random/{number}" }, method = RequestMethod.GET)
       public String generatePlayer(@PathVariable int number, ModelMap model) {
           service.generateRandomPlayers(number);
           
           //model.addAttribute("success", "Employee " + player.getForename()+ " registered successfully");
           return "success";
       }
}