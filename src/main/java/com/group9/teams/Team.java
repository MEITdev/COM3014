/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.teams;

/**
 *
 * @author Black
 */


import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;


import javax.validation.constraints.Size;
 

@Entity
@Table(name="TEAMS")
public class Team implements Serializable {
 
    @Id
    @Size(min=4, max=50)
    @Column(name = "name", nullable = false)
    private String name;
 
    
    @Min(0)
    @Digits(integer=8, fraction=0)
    @Column(name = "wins", nullable = false)
    private int wins;

    @Min(0)
    @Digits(integer=8, fraction=0)
    @Column(name = "losses", nullable = false)
    private int losses;
        
    @Size(min=4, max=50)
    @Column(name = "owner", nullable = false)
    private String owner;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player1ID", nullable = false)
    private int player1ID;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player2ID", nullable = false)
    private int player2ID;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player3ID", nullable = false)
    private int player3ID;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player4ID", nullable = false)
    private int player4ID;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player5ID", nullable = false)
    private int player5ID;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "player6ID", nullable = false)
    private int player6ID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPlayer1ID() {
        return player1ID;
    }

    public void setPlayer1ID(int player1ID) {
        this.player1ID = player1ID;
    }

    public int getPlayer2ID() {
        return player2ID;
    }

    public void setPlayer2ID(int player2ID) {
        this.player2ID = player2ID;
    }

    public int getPlayer3ID() {
        return player3ID;
    }

    public void setPlayer3ID(int player3ID) {
        this.player3ID = player3ID;
    }

    public int getPlayer4ID() {
        return player4ID;
    }

    public void setPlayer4ID(int player4ID) {
        this.player4ID = player4ID;
    }

    public int getPlayer5ID() {
        return player5ID;
    }

    public void setPlayer5ID(int player5ID) {
        this.player5ID = player5ID;
    }

    public int getPlayer6ID() {
        return player6ID;
    }

    public void setPlayer6ID(int player6ID) {
        this.player6ID = player6ID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    
    
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Team))
            return false;
        Team other = (Team) obj;
        if (name.contentEquals(other.name))
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.name);
        return hash;
    }

   

   
 
     
}