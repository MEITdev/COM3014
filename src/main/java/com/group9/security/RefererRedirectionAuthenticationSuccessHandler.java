/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group9.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author Black
 */
public class RefererRedirectionAuthenticationSuccessHandler 
  extends SimpleUrlAuthenticationSuccessHandler
  implements AuthenticationSuccessHandler {
 
    public RefererRedirectionAuthenticationSuccessHandler() {
        super();
        //setUseReferer(true);
        setDefaultTargetUrl("/");
    }
 
}