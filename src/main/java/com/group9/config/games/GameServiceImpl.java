/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.games;

import com.group9.config.dao.GameDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ivan
 */
@Service("gameService")
@Transactional
public class GameServiceImpl implements GameService{
    
    @Autowired
    private GameDAO dao;

    @Override
    public Game findById(int game) {
        return dao.findById(game);
    }

    @Override
    public void deleteGame(int game) {
        dao.deleteGame(game);
    }

    @Override
    public List<Game> findAllGames() {
        return dao.getAllGames();
    }
    
}
