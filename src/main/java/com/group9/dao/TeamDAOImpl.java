package com.group9.dao;


 
import com.group9.teams.Team;
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
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