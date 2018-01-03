/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.players;

 
import java.util.List;
import org.springframework.security.access.annotation.Secured;
 

 
public interface PlayerService {
    @Secured ({"ROLE_ADMIN", "ROLE_USER", "ROLE_PREMIUM"})
    Player findById(int id);
    @Secured ({"ROLE_ADMIN", "ROLE_PREMIUM"})
    void savePlayer(Player player);
    @Secured ({"ROLE_ADMIN", "ROLE_USER", "ROLE_PREMIUM"})
    void updatePlayer(Player player);
    @Secured ({"ROLE_ADMIN"}) 
    void deletePlayerById(int id);
    @Secured ({"ROLE_ADMIN", "ROLE_USER", "ROLE_PREMIUM"})
    List<Player> findAllPlayers(); 
     
    
 
    boolean isPlayerIDUnique(int id);
     
}