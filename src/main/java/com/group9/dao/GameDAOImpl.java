package com.group9.dao;

import com.group9.games.Game;
import org.hibernate.Criteria;
import org.hibernate.Query;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository("gameDAO")
public class GameDAOImpl extends AbstractDao<Integer, Game> implements GameDAO {

    @Override
    public Game findById(int game) {
        return getByKey(game);
    }

    @Override
    public void deleteGame(int game) {
        Query query = getSession().createSQLQuery("delete from games where game = :game");
        query.setInteger("game", game);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Game> getAllGames() {
        Criteria criteria = createEntityCriteria();
        return (List<Game>) criteria.list();
    }
    
    
    
}
