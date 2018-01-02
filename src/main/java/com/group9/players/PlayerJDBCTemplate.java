/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

/**
 *
 * @author Black
 */
import com.group9.players.*;
import com.group9.config.dao.PlayerDAO;
import com.group9.exceptions.PlayerAlreadyExistsException;
import com.group9.exceptions.PlayerNotFoundException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


public class PlayerJDBCTemplate implements PlayerDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }


    @Override
    public void create(int player_id, String forename, String surname, int salary, int age, int offense, int defense) throws PlayerAlreadyExistsException {
        
        String SQL = "SELECT count(*) FROM players WHERE player_id = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { player_id }, Integer.class);
        
        if(count != 0){
            throw new PlayerAlreadyExistsException("Player "+player_id+" already exists in the database");
        }else{
            SQL = "insert into players (player_id, forename, surname, salary, age, offense, defense) values (?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplateObject.update( SQL, null, forename, surname, salary, age, offense, defense);
                       
        }
        
    }

   @Override
    public Player getPlayer(int player_id) throws PlayerNotFoundException{
        String SQL = "SELECT count(*) FROM players WHERE player_id = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { player_id }, Integer.class);
        
        if(count == 0){
            throw new PlayerNotFoundException("Player "+player_id+" was not found in DB");
        }else{
            SQL = "select * from players where player_id = ?";
            Player player = jdbcTemplateObject.queryForObject(SQL, new Object[]{player_id}, new PlayerMapper());
            return player;
        }
    }
    
    @Override
    public List<Player> listPlayers() {
        String SQL = "select * from players";
        List<Player> players = jdbcTemplateObject.query(SQL, new PlayerMapper());
        
        return players;
    }

}