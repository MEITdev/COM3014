/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.Registration;

import com.group9.exceptions.UserAlreadyExistsException;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import com.group9.login.UserRole;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
  @RequestMapping(value="/register", method=RequestMethod.GET)
  public String viewRegistrationPage (ModelMap map)
  {

  	return "register";
  }
	
  
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  public String handleRegistration (@RequestParam String username,@RequestParam String password,
          @RequestParam String email, ModelMap map)
  {
        
        try {
            Set<UserRole> roles = new HashSet<UserRole>() {{add(UserRole.USER);}};
            userJDBCTemplate.create(username, password, email, 1, roles);
            map.put("message", "User successfully registered!");
        } catch (UserAlreadyExistsException ex) {
            map.put("message", "Username already taken!");
        }
  	return "register";
  }
}
