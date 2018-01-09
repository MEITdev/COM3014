/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.login;

import com.group9.config.players.PlayerService;
import com.group9.config.teams.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController
{
     
@RequestMapping(value="/login", method=RequestMethod.GET)
  public String loginPage (ModelMap map)
  {
  	
  	return "login";
  }
	
}
