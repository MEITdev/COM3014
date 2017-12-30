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
import com.group9.exceptions.RoleNotRecognised;
import com.group9.generic.BCryptHelper;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.group9.exceptions.UserAlreadyExistsException;
import com.group9.exceptions.UserNotFoundException;
import com.group9.generic.GenericHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UserJDBCTemplate implements UserDAO {
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public void create(String username, String password, String email, int enabled, Set<UserRole> roles) throws UserAlreadyExistsException {
        
        String SQL = "SELECT count(*) FROM users WHERE username = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username }, Integer.class);
        
        if(count != 0){
            throw new UserAlreadyExistsException("User "+username+" already exists in the database");
        }else{
            SQL = "insert into users (username, password, email, enabled) values (?, ?, ?, ?)";
            jdbcTemplateObject.update( SQL, username, BCryptHelper.encrypt(password), email, 1);
            
            Iterator<UserRole> iterator = roles.iterator();
            while(iterator.hasNext()) {
                UserRole setElement = iterator.next();
                
                SQL = "insert into authorities (username, authority) values (?, ?)";
                jdbcTemplateObject.update( SQL, username, GenericHelper.roleToString(setElement));
                
            }
            
        }
        
    }

    @Override
    public User getUser(String username) throws UserNotFoundException{
        String SQL = "SELECT count(*) FROM users WHERE username = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username }, Integer.class);
        
        if(count == 0){
            throw new UserNotFoundException("User "+username+" was not found in DB");
        }else{
            SQL = "select * from users where username = ?";
            User user = jdbcTemplateObject.queryForObject(SQL, new Object[]{username}, new UserMapper());
            addUserRoles(user);
            return user;
        }
    }
    
    public void addUserRoles(User user){
        String SQL = "select authority from authorities where username = ?";
        List<String> auths = jdbcTemplateObject.queryForList(SQL, new Object[] {user.getUsername()}, String.class);
        Set<UserRole> roles = new HashSet<>();
        for (String auth: auths){
            try {
                roles.add(GenericHelper.stringToRole(auth));
            } catch (RoleNotRecognised ex) {
                Logger.getLogger(UserJDBCTemplate.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        user.setRoles(roles);
    
    }
    
    @Override
    public List<User> listUsers() {
        String SQL = "select * from users";
        List<User> users = jdbcTemplateObject.query(SQL, new UserMapper());
        
        for(User user:users){
            addUserRoles(user);
        }
        
        return users;
    }

    @Override
    public void delete(String username) throws UserNotFoundException {
        String SQL = "SELECT count(*) FROM users WHERE username = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username }, Integer.class);
        
        if(count == 0){
            throw new UserNotFoundException("User "+username+" was not found in DB");
        }else{
            SQL = "delete from users where username = ?";
            jdbcTemplateObject.update(SQL, username);
        }
    }

    @Override
    public void update(String username, String password, String email, int enabled, Set<UserRole> roles) throws UserNotFoundException {
        String SQL = "SELECT count(*) FROM users WHERE username = ?";
        int count = jdbcTemplateObject.queryForObject(SQL, new Object[] { username }, Integer.class);
        
        if(count == 0){
            throw new UserNotFoundException("User "+username+" was not found in DB");
        }else{
            SQL = "update users set password = ?, email = ?, enabled = ? where username = ?";
            jdbcTemplateObject.update(SQL, password, email, enabled, username);
            
            SQL = "delete from authorities where username = ?";
            jdbcTemplateObject.update(SQL, username);
            
            Iterator<UserRole> iterator = roles.iterator();
            while(iterator.hasNext()) {
                UserRole setElement = iterator.next();
                
                SQL = "insert into authorities (username, authority) values (?, ?)";
                jdbcTemplateObject.update( SQL, username, GenericHelper.roleToString(setElement));
                
            }
        }
    }

}