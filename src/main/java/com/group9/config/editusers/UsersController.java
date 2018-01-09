/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.editusers;

import com.group9.config.games.GameController;
import com.group9.config.teams.TeamService;
import com.group9.exceptions.TeamNameAlreadyExists;
import com.group9.exceptions.UserAlreadyExistsException;
import com.group9.exceptions.UserNotFoundException;
import com.group9.generic.BCryptHelper;
import com.group9.generic.GenericHelper;
import com.group9.login.UserJDBCTemplate;
import com.group9.login.UserRole;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Black
 */

@Controller
public class UsersController {
    
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    
    @Autowired
    TeamService teamService;
    
    @RequestMapping(value="/admin/users", method=RequestMethod.GET)
    public String viewRegistrationPage (ModelMap map, Principal principal)
    {
        map.put("users", userJDBCTemplate.listUsers());
        GenericHelper.handleUserInfo(map, principal, userJDBCTemplate);
        return "listusers";
    }
    
   
    
    //UPDATES
    @RequestMapping(value="/admin/users/{username}/update", method=RequestMethod.GET)
    public String viewUpdatePage (@PathVariable("username") String username, ModelMap map, Principal principal)
    {
        try {
            map.put("user", userJDBCTemplate.getUser(username));
        } catch (UserNotFoundException ex) {
            map.put("error", "Could not find user "+username);
        }
        GenericHelper.handleUserInfo(map, principal, userJDBCTemplate);
        
        return "updateuser";
    }
    
    @RequestMapping(value="/admin/users/{username}/update", method=RequestMethod.POST)
    public String updateUser (@RequestParam String username,@RequestParam String password,
            @RequestParam String email, @RequestParam int budget, @RequestParam String teamName, Principal principal,
            @RequestParam(value = "admin", required = false) String admin, 
            @RequestParam(value = "user", required = false)     String user,
            @RequestParam(value = "enabled", required = false)  String enabled,
            @RequestParam(value = "premium", required = false)  String premium, ModelMap map)
    {
        
         try {
                Set<UserRole> roles = new HashSet<>();
                
                if(admin != null && admin.contains("on")){
                    roles.add(UserRole.ADMIN);
                }
                if(user != null && user.contains("on")){
                    roles.add(UserRole.USER);
                }
                if(premium != null && premium.contains("on")){
                    roles.add(UserRole.PREMIUM);
                }
                int in_enabled = 0;
                if(enabled != null && enabled.contains("on")){
                    in_enabled = 1;
                }
                
                //if password is new, encrypt it. If it is the old one, leave it as is
                if(!password.contentEquals(userJDBCTemplate.getUser(username).getPassword())){
                    password = BCryptHelper.encrypt(password);
                }
                
                userJDBCTemplate.update(username, password, email, in_enabled, roles, budget, teamName);
                map.put("message", "User successfully updated!");
                
          } catch (UserNotFoundException ex) {
              map.put("message", "Failed updating user, user no longer exists!");
          }
        try {
            map.addAttribute("isAdmin", ( principal != null &&  (GenericHelper.isAdmin(userJDBCTemplate.getUser(principal.getName()).getRoles()))));
            if( principal != null) {map.addAttribute("userbudget", userJDBCTemplate.getUser(principal.getName()).getBudget());}
        } catch (UserNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/users";
    }
    
    //DELETE
    @RequestMapping(value="/admin/users/delete", method=RequestMethod.POST)
    public String deleteUser (@RequestParam String username, ModelMap map, Principal principal)
    {
        try {
            teamService.deleteTeam(userJDBCTemplate.getUser(username).getTeamName());
            userJDBCTemplate.delete(username);
            
            map.put("message", "User has been deleted");
            
        } catch (UserNotFoundException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            map.put("message", "User could not be delted");
        } 
        try {
            map.addAttribute("isAdmin", ( principal != null &&  (GenericHelper.isAdmin(userJDBCTemplate.getUser(principal.getName()).getRoles()))));
            if( principal != null) {map.addAttribute("userbudget", userJDBCTemplate.getUser(principal.getName()).getBudget());}
        } catch (UserNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "redirect:/admin/users";
    }
    
    //ADDING USERS
    @RequestMapping(value="/admin/users/add", method=RequestMethod.GET)
    public String viewAddUsersPage (ModelMap map, Principal principal)
    {
        try {
            map.addAttribute("isAdmin", ( principal != null &&  (GenericHelper.isAdmin(userJDBCTemplate.getUser(principal.getName()).getRoles()))));
            if( principal != null) {map.addAttribute("userbudget", userJDBCTemplate.getUser(principal.getName()).getBudget());}
        } catch (UserNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "adduser";
    }
    
 
    
    @RequestMapping(value="/admin/users/add", method=RequestMethod.POST)
    public String handleRegistration (@RequestParam String username,@RequestParam String password,
            @RequestParam String email,@RequestParam int budget, @RequestParam String teamName, 
            @RequestParam(value = "admin", required = false) String admin, 
            @RequestParam(value = "user", required = false)  String user, @RequestParam(value = "premium", required = false)  
                    String premium, ModelMap map, Principal principal)
    {
        try {
        map.addAttribute("isAdmin", ( principal != null &&  (GenericHelper.isAdmin(userJDBCTemplate.getUser(principal.getName()).getRoles()))));
        if( principal != null) {map.addAttribute("userbudget", userJDBCTemplate.getUser(principal.getName()).getBudget());}
        } catch (UserNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

          try {
              
                Set<UserRole> roles = new HashSet<>();
                
                if(admin != null && admin.contains("on")){
                    roles.add(UserRole.ADMIN);
                }
                if(user != null && user.contains("on")){
                    roles.add(UserRole.USER);
                }
                if(premium != null && premium.contains("on")){
                    roles.add(UserRole.PREMIUM);
                }
                
                userJDBCTemplate.create(username, password, email, 1, roles, budget, teamName);
                map.put("message", "User successfully registered!");
                
                
          } catch (UserAlreadyExistsException ex) {
                map.put("message", "Username already taken!");
                return "adduser";
          } catch (TeamNameAlreadyExists ex) {
                map.put("message", "Team name already exists!");
                return "adduser";
        }
        return "redirect:/admin/users";
          
    }
    
    
}
