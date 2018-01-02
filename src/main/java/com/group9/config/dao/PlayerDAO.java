/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.dao;

import com.group9.exceptions.PlayerAlreadyExistsException;
import com.group9.exceptions.PlayerNotFoundException;
import com.group9.login.User;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import com.group9.players.Player;
/**
 *
 * @author Black
 */
public interface PlayerDAO {
   
   public void setDataSource(DataSource ds);
   
   public void create(int player_id, String forename, String surname, int salary, int age, int offense, int defense) throws PlayerAlreadyExistsException;
   
   
   public Player getPlayer(int player_id) throws PlayerNotFoundException;
   
   
   public List<Player> listPlayers();
   
   //public void delete(String username) throws UserNotFoundException;
   
   
   //public void update(String username, String password, String email, int enabled, Set<UserRole> roles) throws UserNotFoundException;
}
    

