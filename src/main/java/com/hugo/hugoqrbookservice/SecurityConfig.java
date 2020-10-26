package com.hugo.hugoqrbookservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        System.out.println("setting up form login");
        httpSecurity
                .authorizeRequests()

                .antMatchers("/add", "/update", "/delete").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin(formLogin ->
                        formLogin.loginPage("/login").permitAll()
                );
    }
}
