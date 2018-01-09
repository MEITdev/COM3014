/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.dao;


 
import com.group9.players.Player;
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 

 
@Repository("playerDAO")
public class PlayerDAOImpl extends AbstractDao<Integer, Player> implements PlayerDAO {
 
    @Override
    public Player findById(int id) {
        return getByKey(id);
    }
 
    @Override
    public void savePlayer(Player player) {
        persist(player);
    }
 
    @Override
    public void deletePlayerById(int id){
        Query query = getSession().createSQLQuery("delete from player where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Player> getAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }
 
    /*
    RESTRICTIONS
    public Player getPlayerWithRestriction(String ssn) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("ssn", ssn));
        return (Player) criteria.uniqueResult();
    }
    */

    @Override
    public void updatePlayer(Player player) {
        update(player);
    }

}