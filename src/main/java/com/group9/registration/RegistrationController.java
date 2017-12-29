/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.Registration;

import com.group9.login.UserJDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
  public String handleRegistration (@RequestParam String name,@RequestParam String password,
          @RequestParam String email, ModelMap map)
  {

        userJDBCTemplate.create(name, password, email, 1);
  	return "register";
  }
}
