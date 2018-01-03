/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.players;

import com.group9.config.dao.PlayerDAO;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 

 
@Service("employeeService")
@Transactional
public class PlayerServiceImpl implements PlayerService {
 
    @Autowired
    private PlayerDAO dao;
     
    @Override
    public Player findById(int id) {
        return dao.findById(id);
    }
 
    @Override
    public void savePlayer(Player player) {
        dao.savePlayer(player);
    }
 

    @Override
    public void updatePlayer(Player player) {
        Player entity = dao.findById(player.getId());
        if(entity!=null){
            entity.setForename(player.getForename());
            entity.setSurname(player.getSurname());
            entity.setSalary(player.getSalary());
            entity.setDefense(player.getDefense());   
        }
    }
 
    @Override
    public void deletePlayerById(int id) {
        dao.deletePlayerById(id);
    }
     
    @Override
    public List<Player> findAllPlayers() {
        return dao.getAllPlayers();
    }
 
 
 
    @Override
    public boolean isPlayerIDUnique(int id) {
        Player player = findById(id);
        return ( player == null || ((player.getId() == id)));
    }
     
}