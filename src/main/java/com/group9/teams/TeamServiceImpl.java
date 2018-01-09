package com.group9.teams;

import com.group9.dao.TeamDAO;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 


@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
 
    
    //Include team DAO for interaction with DB
    @Autowired
    private TeamDAO dao;
    
    /**
     * Returns Team or null if team not found
     * @param name
     * @return 
     */
    @Override
    public Team findByName(String name) {
        return dao.findByName(name);
    }
    /**
     * Saves a new team
     * @param team 
     */
    @Override
    public void saveTeam(Team team) {
        dao.saveTeam(team);
    }
    /**
     * Updates a team
     * @param team 
     */
    @Override
    public void updatePostTeam(Team team) {
        dao.updateTeam(team);
    }
   
    /**
     * Gets latest data of team 
     * @param team 
     */
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
    /**
     * Deletes team
     * @param name 
     */
    @Override
    public void deleteTeam(String name) {
        dao.deleteTeam(name);
    }
    /**
     * Returns all teams
     * @return 
     */
    @Override
    public List<Team> findAllTeams() {
        return dao.getAllTeams();
    }
    /**
     * Check if teamname is already in database
     * @param name
     * @return 
     */
    @Override
    public boolean hasTeamUniqueName(String name) {
        Team team = findByName(name);
        return ( team == null);
    }
     
}