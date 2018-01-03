/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.dao;

import com.group9.config.players.Player;
import java.util.List;


/**
 *
 * @author Black
 */

public interface PlayerDAO {
 
    Player findById(int id);
 
    void savePlayer(Player player);
     
    void deletePlayerById(int id);
     
    List<Player> getAllPlayers();
 
    
 
}