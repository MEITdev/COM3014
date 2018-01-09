/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.dao;


import com.group9.teams.Team;
import com.group9.login.User;
import java.util.List;


/**
 *
 * @author Black
 */

public interface TeamDAO {
 
    Team findByName(String name);
 
    void saveTeam(Team team);
     
    void deleteTeam(String name);
     
    List<Team> getAllTeams();
    public void updateTeam(Team team);
 
}