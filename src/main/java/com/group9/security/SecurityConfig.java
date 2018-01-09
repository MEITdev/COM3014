package com.group9.security;


import com.group9.generic.Registry;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
   
    @Autowired 
    private BCryptPasswordEncoder encryptionEncoder;
    
    @Autowired
    private DataSource dataSource;
    

    /***
     * Ensure usage of datasource bean and Bcrypt encryption
     * @param auth
     * @throws Exception 
     */
    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception
    {
      auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(encryptionEncoder);
    }
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            //Permit public access only to the sites in registry
            .antMatchers(Registry.publicSites).permitAll()
                //Allow only admin access based on registry
            .antMatchers(Registry.adminSites).hasRole("ADMIN").
                anyRequest().authenticated()
                .and()
                .formLogin().successHandler(new RefererRedirectionAuthenticationSuccessHandler())
                .loginPage("/login").and().
                
                //Force application to be redirected to secure ssl/HTTPS
            httpBasic().and().requiresChannel().anyRequest().requiresSecure();
        
        
        

  }
}
