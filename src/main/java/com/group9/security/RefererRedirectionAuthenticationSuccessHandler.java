package com.group9.security;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * Redirect user to / after successful login
 * @author Black
 */
public class RefererRedirectionAuthenticationSuccessHandler 
  extends SimpleUrlAuthenticationSuccessHandler
  implements AuthenticationSuccessHandler {
 
    public RefererRedirectionAuthenticationSuccessHandler() {
        super();
        
        setDefaultTargetUrl("/");
    }
 
}