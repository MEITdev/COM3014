package com.group9.generic;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Black
 */
public class BCryptHelper {
    public static String encrypt(String text){
        BCryptPasswordEncoder en = new BCryptPasswordEncoder();
        return en.encode(text);
    }
}
