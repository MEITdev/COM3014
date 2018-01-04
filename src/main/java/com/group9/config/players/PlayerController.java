/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.players;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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