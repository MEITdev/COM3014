/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.teams;

 

import java.util.List;

 

 
public interface TeamService {
    
    Team findByName(String name);
    
    void saveTeam(Team team);
    
    void updateTeam(Team team);
    void updatePostTeam(Team team);
    
    void deleteTeam(String name);
    
    List<Team> findAllTeams(); 
 
    boolean hasTeamUniqueName(String Name);
    

     
}