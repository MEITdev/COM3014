/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.Registration;

import com.group9.exceptions.TeamNameAlreadyExists;
import com.group9.exceptions.UserAlreadyExistsException;
import com.group9.generic.Registry;
import com.group9.login.UserJDBCTemplate;
import com.group9.login.UserRole;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController
{ 
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    
    /**
     * Return view registration jsp
     * @param map
     * @return 
     */
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String viewRegistrationPage (ModelMap map)
    {
      return "register";
    }
	
  
   /**
    * Handle registration POST request, ensuring correct error handling
    * @param username
    * @param password
    * @param email
    * @param teamName
    * @param map
    * @return 
    */
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String handleRegistration (@RequestParam String username,@RequestParam String password,
          @RequestParam String email, @RequestParam String teamName, ModelMap map)
  {
        if(username.length() < 4 || username.length() > 40){
            map.put("message", "Username has to be between 4 and 40 characters long");
            return "register";
        }  
        if(email.length() < 4 || email.length() > 40){
            map.put("message", "Email has to be between 4 and 40 characters long");
            return "register";
        }  
        if(password.length() < 4 || password.length() > 40){
            map.put("message", "Password has to be between 4 and 40 characters long");
            return "register";
        }  
        try {
            //If all checks were successful, create a new user using JDBC template
            Set<UserRole> roles = new HashSet<UserRole>() {{add(UserRole.USER);}};
            userJDBCTemplate.create(username, password, email, 1, roles, Registry.startingBudget, teamName);
            map.put("message", "User successfully registered!");
            return "redirect:/login";
        } catch (UserAlreadyExistsException ex) {
            map.put("message", "Username already taken!");
        } catch (TeamNameAlreadyExists ex) {
            map.put("message", "TeamName already in use!");
        }
        
  	return "register";
  }
}
