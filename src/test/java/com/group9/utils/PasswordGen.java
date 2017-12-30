/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.utils;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Black
 */
public class PasswordGen {
        @Test
        public void generatePass(){
            BCryptPasswordEncoder en = new BCryptPasswordEncoder();
            System.out.println(en.encode("pass"));
        }
}
