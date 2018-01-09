/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.dao;


 
import com.group9.config.players.Player;
import com.group9.config.teams.Team;
import com.group9.login.User;
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 

 
@Repository("teamDAO")
public class TeamDAOImpl extends AbstractDao<String, Team> implements TeamDAO {
 
    
    @Override
    public void updateTeam(Team team) {
        
        update(team);
    }
    
    
    @Override
    public Team findByName(String name) {
        return getByKey(name);
    }

    @Override
    public void saveTeam(Team team) {
         persist(team);
    }

    @Override
    public void deleteTeam(String name) {
        Query query = getSession().createSQLQuery("delete from teams where name = :name");
        query.setString("name", name);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Team> getAllTeams() {
        Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
    }

}