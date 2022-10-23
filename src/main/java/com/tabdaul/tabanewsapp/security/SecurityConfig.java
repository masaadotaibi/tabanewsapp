package com.tabdaul.tabanewsapp.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] PUBLIC_ENDPOINTS = {
            "/article",
            "/article/*"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // this to indicate that the session is stateless (it is REST, and we are going to use JWT)
                    .and()
                .authorizeRequests() // to indicate what paths will need authorization
                    .antMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .httpBasic(); // For our request to be authenticated, we need to call this method
        ;
    }
}
