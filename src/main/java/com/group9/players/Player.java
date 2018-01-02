/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.players;

/**
 *
 * @author Ivan
 */
public class Player {
    
    private int player_id;
    private String forename;
    private String surname;
    private int salary;
    private int age;
    private int offense;
    private int defense;
    
    public int getPlayerId(){
        return player_id;
    }
    
    public void setPlayerId(int player_id){
        this.player_id = player_id;
    }
    
    public String getForename(){
        return forename;
    }
    
    public void setForename(String forename){
        this.forename = forename;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public int getSalary(){
        return salary;
    }
    
    public void setSalary(int salary){
        this.salary = salary;
    }
    
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public int getOffense(){
        return offense;
    }
    
    public void setOffense(int ofense){
        this.offense = ofense;
    }
    
    public int getDefense(){
        return defense;
    }
    
    public void setDefense(int defense){
        this.defense = defense;
    }
}
