package com.budgetor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun configure(http : HttpSecurity) : SecurityFilterChain {
        return http.csrf().disable()
                   .authorizeRequests()
                   //authorize all home page sites
                   .antMatchers("/").permitAll()
                   .antMatchers("/about").permitAll()
                   .antMatchers("/app").permitAll()
                   .antMatchers("/contact").permitAll()
                   .antMatchers("/signUp").permitAll()
                   .antMatchers("/error").permitAll()
                   //only allow users with credentials to look at budgetor sites
                   .antMatchers("/auth").hasRole("USER")
                   .and()
                   .httpBasic()
                   .and().build();
    }
}