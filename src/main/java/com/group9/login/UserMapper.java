/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.login;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
   @Override
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      user.setBudget(rs.getInt("budget"));
      user.setTeamName(rs.getString("teamName"));
      
      user.setEnabled(rs.getInt("enabled"));
      
      return user;
   }
}