package com.group9.dao;

import com.group9.exceptions.TeamNameAlreadyExists;
import com.group9.exceptions.UserAlreadyExistsException;
import com.group9.exceptions.UserNotFoundException;
import com.group9.login.User;
import java.util.List;
import java.util.Set;
import javax.sql.DataSource;
import com.group9.login.UserRole;

public interface UserDAO {
   
   public void setDataSource(DataSource ds);
   
   public void create(String username, String password, String email, int enabled, Set<UserRole> roles, int budget, String teamName) throws UserAlreadyExistsException, TeamNameAlreadyExists;
   
   
   public User getUser(String username) throws UserNotFoundException;
   
   
   public List<User> listUsers();
   
   public void delete(String username) throws UserNotFoundException;
   
   public void updateBudget(String username, int budget);
   public void update(String username, String password, String email, int enabled, Set<UserRole> roles, int budget, String teamName) throws UserNotFoundException, TeamNameAlreadyExists;
}
    

