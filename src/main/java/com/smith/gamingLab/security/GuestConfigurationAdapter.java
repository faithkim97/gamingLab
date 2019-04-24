package com.smith.gamingLab.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@Order(2)
public class GuestConfigurationAdapter extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http.antMatcher("/game/**")
                .authorizeRequests().anyRequest().permitAll();
        http.addFilterBefore(new CorsFilter(), BasicAuthenticationFilter.class);

    }
}
