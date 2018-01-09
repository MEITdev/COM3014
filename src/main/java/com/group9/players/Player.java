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

import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import javax.validation.constraints.Size;
 
 
@Entity
@Table(name="PLAYER")
public class Player implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "FORENAME", nullable = false)
    private String forename;
    
    @Size(min=3, max=50)
    @Column(name = "SURNAME", nullable = false)
    private String surname;
    
    @Min(1)
    @Digits(integer=11, fraction=0)
    @Column(name = "SALARY", nullable = false)
    private int salary;

    @Max(99)
    @Min(1)
    @Digits(integer=3, fraction=0)
    @Column(name = "AGE", nullable = false)
    private int age;
        
    
    
    @Max(99)
    @Min(1)
    @Digits(integer=3, fraction=0)
    @Column(name = "OFFENSE", nullable = false)
    private int offense;
    
    
    @Max(99)
    @Min(1)
    @Digits(integer=3, fraction=0)
    @Column(name = "DEFENSE", nullable = false)
    private int defense;
    

    @Digits(integer=1, fraction=0)
    @Column(name = "INTEAM", nullable = false)
    private int inTeam;
    

    
    
    
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }

    public int getInTeam() {
        return inTeam;
    }

    public void setInTeam(int inTeam) {
        this.inTeam = inTeam;
    }
    
  
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Player))
            return false;
        Player other = (Player) obj;
        if (id != other.id)
            return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

   
 
     
}