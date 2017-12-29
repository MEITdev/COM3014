/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.config.dao;

import com.group9.login.User;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Black
 */
public interface UserDAO {
   
   public void setDataSource(DataSource ds);
   
   public void create(String username, String password, String email, int enabled);
   
   
   public User getUser(String username);
   
   
   public List<User> listUsers();
   
   public void delete(String username);
   
   
   public void update(String username, String password, String email, int enabled);
}
    

