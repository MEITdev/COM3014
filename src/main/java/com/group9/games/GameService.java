/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.games;

import java.util.List;

/**
 *
 * @author Ivan
 */
public interface GameService {
    
    Game findById(int game);
    
    void deleteGame(int game);
    
    List<Game> findAllGames();
        
}
