/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

 
import com.group9.login.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
 

 
public interface PlayerService {
    
    Player findById(int id);
    
    void savePlayer(Player player);
    
    void getUpdatePlayer(Player player);
    
    void updatePlayer(Player player);
    
    void deletePlayerById(int id);
    
    List<Player> findAllPlayers(); 
     
    
    ArrayList<Player> generateRandomPlayers(int numberOfPlayers);
    
    public ArrayList<Player> getFreePlayers();
 
    boolean isPlayerIDUnique(int id);
    
    ArrayList<Player> getPlayers(User user);
    
     
}