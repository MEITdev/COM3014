package com.group9.teams;

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