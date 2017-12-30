/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.login;

import java.util.Iterator;

/**
 *
 * @author Black
 */
public class RoleHolder {

    private String isAdmin = "no";
    private String isUser = "no";
    private String isPremium = "no";
    public RoleHolder(User user) {
            
            Iterator<UserRole> it = user.getRoles().iterator();
            UserRole nextEl;
        
            while(it.hasNext()){
                nextEl = it.next();
                if(nextEl == UserRole.USER){
                    this.isUser = "yes";
                }
                if(nextEl == UserRole.PREMIUM){
                    this.isPremium = "yes";
                }
                if(nextEl == UserRole.ADMIN){
                    this.isAdmin = "yes";
                }
            }
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser;
    }

    public String getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(String isPremium) {
        this.isPremium = isPremium;
    }
    
    
    
}
