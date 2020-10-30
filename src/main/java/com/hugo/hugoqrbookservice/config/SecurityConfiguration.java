package com.hugo.hugoqrbookservice.config;

import com.hugo.hugoqrbookservice.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


import java.util.Arrays;

@Configuration
@EnableConfigurationProperties
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    MongoUserDetailsService userDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().httpBasic().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**/get").permitAll()
                .antMatchers("/api/**/add", "/api/**/update", "/api/**/delete").authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService);
    }
}
