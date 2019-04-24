package com.smith.gamingLab.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@Order(1)
public class AdminConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //http.csrf().disable();
        http.antMatcher("/admin/**")
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());

        http.addFilterBefore(new CorsFilter(), BasicAuthenticationFilter.class);


    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        BasicAuthenticationEntryPoint entryPoint =
                new BasicAuthenticationEntryPoint();
        entryPoint.setRealmName("admin realm");
        return entryPoint;
    }
}
