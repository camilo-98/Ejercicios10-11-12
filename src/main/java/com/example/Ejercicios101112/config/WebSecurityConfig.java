package com.example.Ejercicios101112.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/laptops").hasRole("ADMINISTRADOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("vendedor").password(passwordEncoder().encode("vendedor1")).roles("VENDEDOR").and()
                .withUser("administrador").password(passwordEncoder().encode("administrador1")).roles("VENDEDOR", "ADMINISTRADOR");

    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

}
