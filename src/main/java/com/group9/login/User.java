package com.group9.login;

import com.group9.players.Player;
import com.group9.players.PlayerService;
import com.group9.teams.Team;
import com.group9.teams.TeamService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;


public class User {
   private String username;
   private String password;
   private String email;
   private int enabled;
   private Set<UserRole> roles;
   private RoleHolder roleStringHolder;
   private int budget;
   private String teamName;
   
     
   
    public RoleHolder getRoleStringHolder() {
        return roleStringHolder;
    }

    public void setRoleStringHolder(RoleHolder roleStringHolder) {
        this.roleStringHolder = roleStringHolder;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
        this.roleStringHolder = new RoleHolder(this);
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        System.out.println("SETTING TEAM NAME "+teamName);
        this.teamName = teamName;
    }

  

 
    

}