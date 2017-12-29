/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.login;

/**
 *
 * @author Black
 */
import com.group9.config.dao.UserDAO;
import com.group9.generic.BCryptHelper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String username, String password, String email, int enabled) {
        String SQL = "insert into users (username, password, email, enabled) values (?, ?, ?, ?)";
        jdbcTemplateObject.update( SQL, username, BCryptHelper.encrypt(password), email, 1);
    }

    @Override
    public User getUser(String username) {
      String SQL = "select * from users where username = ?";
      User user = jdbcTemplateObject.queryForObject(SQL, new Object[]{username}, new UserMapper());
      
      return user;
    }

    @Override
    public List<User> listUsers() {
        String SQL = "select * from users";
        List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
        return users;
    }

    @Override
    public void delete(String username) {
        String SQL = "delete from users where username = ?";
        jdbcTemplateObject.update(SQL, username);
    }

    @Override
    public void update(String username, String password, String email, int enabled) {
        String SQL = "update users set password = ?, email = ?, enabled = ?, where username = ?";
        jdbcTemplateObject.update(SQL, password, email, enabled, username);
    }

}