package com.tabdaul.tabanewsapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] PUBLIC_ENDPOINTS = {
            "/login",
            "//h2-console",
            "/h2-console/*",
    };

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public AuthFilter authFilter() {
        return new AuthFilter();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // this to indicate that the session is stateless (it is REST, and we are going to use JWT)
                    .and()
                .authorizeRequests() // to indicate what paths will need authorization
                    .antMatchers(PUBLIC_ENDPOINTS).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class);

            http.headers().frameOptions().disable();
    }
}
