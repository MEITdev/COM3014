package com.group9.dao;


import com.group9.teams.Team;
import java.util.List;




public interface TeamDAO {
 
    Team findByName(String name);
 
    void saveTeam(Team team);
     
    void deleteTeam(String name);
     
    List<Team> getAllTeams();
    public void updateTeam(Team team);
 
}