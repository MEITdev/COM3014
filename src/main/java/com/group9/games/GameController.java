/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.games;

import com.group9.players.Player;
import com.group9.players.PlayerService;
import com.group9.teams.Team;
import com.group9.teams.TeamService;
import com.group9.exceptions.UserNotFoundException;
import com.group9.generic.GenericHelper;
import com.group9.login.User;
import com.group9.login.UserJDBCTemplate;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ivan
 */

@Controller
@RequestMapping("/")
public class GameController {
    
    @Autowired
    TeamService service;
    
    @Autowired
    PlayerService playerService;
    
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    
    @GetMapping("game")
    public String listPlayers(ModelMap model, Principal principal) {

        List<Team> teams = service.findAllTeams();
        List<Team> teamsWithoutUser = new ArrayList<>();
        
        if(principal != null){

            try {
                String username = userJDBCTemplate.getUser(principal.getName()).getUsername();
                for(Team t :teams){
                    if(!username.contentEquals(t.getOwner())){
                        teamsWithoutUser.add(t);
                    }

                }
            } catch (UserNotFoundException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        model.addAttribute("teams", teamsWithoutUser);
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        return "allteams";
        
    }
    
    @GetMapping("standings")
    public String standings(ModelMap model, Principal principal) {

        List<Team> teams = service.findAllTeams();       

        model.addAttribute("teams", teams);
        
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        return "standings";
    }
    
    @GetMapping("game/play/{name}")
    public String playGame(ModelMap model, @PathVariable String name, Principal principal){
        
        
        
        User currentUser;
        Team homeTeam;
        ArrayList<Player> homeTeamPlayers;
        
        Team awayTeam; 
        User opposingUser;
        ArrayList<Player> awayTeamPlayers;
        
        try {
            
            // Get current user
            currentUser = userJDBCTemplate.getUser(principal.getName());
             
            // Get current team
            homeTeam = service.findByName(currentUser.getTeamName());
            
            // Get current team players
            homeTeamPlayers = playerService.getPlayers(currentUser);
            
            int homeTeamOff = 0;
            int homeTeamDef = 0;
            
            // Get current team's offense and defense totals
            for(Player p : homeTeamPlayers){
                int offense = p.getOffense();
                homeTeamOff += offense;
                int defense = p.getDefense();
                homeTeamDef += defense;
            }
            
            // Get opposing team
            awayTeam = service.findByName(name);
            
            // Get opposing user
            opposingUser =  userJDBCTemplate.getUser(awayTeam.getOwner());
            
            // Get opposing team's players
            awayTeamPlayers = playerService.getPlayers(opposingUser);
            
            int awayTeamOff = 0;
            int awayTeamDef = 0;
            
            // Get opposing team's offense and defense totals
            for(Player p : awayTeamPlayers){
                int offense = p.getOffense();
                awayTeamOff += offense;
                int defense = p.getDefense();
                awayTeamDef += defense;
            }
            
            String winningTeam;
            String losingTeam;
            int winningTeamRes = getRandomNumberInRange(3,5);
            int losingTeamRes = getRandomNumberInRange(0,2);
            //int drawRes = getRandomNumberInRange(0,2);
            
            if((homeTeamOff + homeTeamDef) > (awayTeamOff + awayTeamDef)){
                winningTeam = homeTeam.getName();
                losingTeam = awayTeam.getName();
            } else {
                winningTeam = awayTeam.getName();
                losingTeam = homeTeam.getName();
            }
            
            Team t1 = service.findByName(winningTeam);
            Team t2 = service.findByName(losingTeam);
            
            System.out.println("Winning team "+t1.getName()+" "+t1.getWins());
            System.out.println("Loosing team "+t1.getName()+" "+t1.getLosses());
            
            // Increment the number of wins for the winning team
            t1.setWins(t1.getWins()+1);
            
            // Increment the number of losses for the losing team
            t2.setLosses(t2.getLosses()+1);
            
            
            // Update database with current results
            service.updatePostTeam(t1);
            service.updatePostTeam(t2);
            
            
            
            model.addAttribute("winningTeam", winningTeam);
            model.addAttribute("losingTeam", losingTeam);
            model.addAttribute("winningTeamRes", winningTeamRes);
            model.addAttribute("losingTeamRes", losingTeamRes);    
            
        } catch (UserNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        GenericHelper.handleUserInfo(model, principal, userJDBCTemplate);
        
        return "gameResult";
    }
    
    private static int getRandomNumberInRange(int min, int max) {

	if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
	}

	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;
    }
}
