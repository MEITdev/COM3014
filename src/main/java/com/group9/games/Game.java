/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.games;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

/**
 *
 * @author Ivan
 */

@Entity
@Table(name="GAMES")
public class Game implements Serializable {
    
        @Id
    @Column(name = "game", nullable = false)
    private int game;
 
    @Column(name = "home_team")
    private String home_team;

    @Column(name = "away_team")
    private String away_team;
        
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "home_team_result", nullable = false)
    private int home_team_result;
    
    @Min(0)
    @Digits(integer=11, fraction=0)
    @Column(name = "away_team_result", nullable = false)
    private int away_team_result;
    
    @Column(name = "winner_team")
    private String winner_team;

    @Column(name = "losing_team")
    private String losing_team;

    public int getGame() {
        return game;
    }

    public void setGame(int game) {
        this.game = game;
    }

    public String getHome_team() {
        return home_team;
    }

    public void setHome_team(String home_team) {
        this.home_team = home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public void setAway_team(String away_team) {
        this.away_team = away_team;
    }

    public int getHome_team_result() {
        return home_team_result;
    }

    public void setHome_team_result(int home_team_result) {
        this.home_team_result = home_team_result;
    }

    public int getAway_team_result() {
        return away_team_result;
    }

    public void setAway_team_result(int away_team_result) {
        this.away_team_result = away_team_result;
    }

    public String getWinner_team() {
        return winner_team;
    }

    public void setWinner_team(String winner_team) {
        this.winner_team = winner_team;
    }

    public String getLosing_team() {
        return losing_team;
    }

    public void setLosing_team(String losing_team) {
        this.losing_team = losing_team;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.game;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Game other = (Game) obj;
        if (this.game != other.game) {
            return false;
        }
        return true;
    }
    
    
    
}
