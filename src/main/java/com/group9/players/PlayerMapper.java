/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PlayerMapper implements RowMapper<Player> {
   public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
      Player player = new Player();
      player.setPlayerId(rs.getInt("player_id"));
      player.setForename(rs.getString("forename"));
      player.setSurname(rs.getString("surname"));
      player.setSalary(rs.getInt("salary"));
      player.setAge(rs.getInt("age"));
      player.setOffense(rs.getInt("offense"));
      player.setDefense(rs.getInt("defense"));

      return player;
   }
}