/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.index;


import java.security.Principal;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController
{
@RequestMapping(value="/", method=RequestMethod.GET)
  public String welcomePage (ModelMap model, Principal principal)
  {

    if(     SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
        model.put("principal", principal);
        return "logged_welcome";
    }
    return "login";
    
  }
	
}
