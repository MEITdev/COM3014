/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.index;


import com.group9.config.players.Player;
import com.group9.config.players.PlayerService;
import com.group9.config.teams.Team;
import com.group9.config.teams.TeamService;
import com.group9.exceptions.UserNotFoundException;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import java.security.Principal;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    
       @Autowired
    TeamService teamService;
     
    @Autowired
    PlayerService playerService;
    
    
@RequestMapping(value="/", method=RequestMethod.GET)
  public String welcomePage (ModelMap model, Principal principal)
  {

    if(     SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
        try {
            model.put("principal", principal);
            User currentUser = userJDBCTemplate.getUser(principal.getName());
            model.put("user", currentUser);
            model.put("players", getPlayers(currentUser));
            
            return "logged_welcome";
        } catch (UserNotFoundException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return "index";
    
  }
  
  @RequestMapping(value="/team", method=RequestMethod.GET)
    public String viewTeamRosterPage (ModelMap model, Principal principal)
    {
        if(     SecurityContextHolder.getContext().getAuthentication() != null &&
            SecurityContextHolder.getContext().getAuthentication().isAuthenticated() &&
            !(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) ){
        try {
            model.put("principal", principal);
            User currentUser = userJDBCTemplate.getUser(principal.getName());
            model.put("user", currentUser);
            model.put("players", getPlayers(currentUser));
            model.put("freePlayers", playerService.getFreePlayers());
            
            return "team_roster";
        } catch (UserNotFoundException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        return "login";
    }
  
    public ArrayList<Player> getPlayers(User user){
        ArrayList<Player> players = new ArrayList<>();
        
        Team t = teamService.findByName(user.getTeamName());
        players.add(playerService.findById(t.getPlayer1ID()));
        players.add(playerService.findById(t.getPlayer2ID()));
        players.add(playerService.findById(t.getPlayer3ID()));
        players.add(playerService.findById(t.getPlayer4ID()));
        players.add(playerService.findById(t.getPlayer5ID()));
        players.add(playerService.findById(t.getPlayer6ID()));
                
        return players;
    }
	
}
