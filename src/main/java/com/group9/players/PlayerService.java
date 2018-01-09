package com.group9.players;

 
import com.group9.login.User;
import java.util.ArrayList;
import java.util.List;
 

 
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