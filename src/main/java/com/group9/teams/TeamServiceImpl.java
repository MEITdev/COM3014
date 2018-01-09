/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.teams;

import com.group9.dao.TeamDAO;
import com.group9.players.Player;
import com.group9.login.User;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

 
@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
 
    @Autowired
    private TeamDAO dao;
    
    @Override
    public Team findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public void saveTeam(Team team) {
        dao.saveTeam(team);
    }
    
    @Override
    public void updatePostTeam(Team team) {
        dao.updateTeam(team);
    }
   

    @Override
    public void updateTeam(Team team) {
        Team entity = dao.findByName(team.getName());
        if(entity!=null){
            entity.setWins(team.getWins());
            entity.setLosses(team.getLosses());
            entity.setPlayer1ID(team.getPlayer1ID());
            entity.setPlayer2ID(team.getPlayer2ID());
            entity.setPlayer3ID(team.getPlayer3ID());
            entity.setPlayer4ID(team.getPlayer4ID());
            entity.setPlayer5ID(team.getPlayer5ID());
            entity.setPlayer6ID(team.getPlayer6ID());
        }
    }

    @Override
    public void deleteTeam(String name) {
        dao.deleteTeam(name);
    }

    @Override
    public List<Team> findAllTeams() {
        return dao.getAllTeams();
    }

    @Override
    public boolean hasTeamUniqueName(String name) {
        Team team = findByName(name);
        return ( team == null);
    }
     
}