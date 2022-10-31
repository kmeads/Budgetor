package com.budgetor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import com.budgetor.service.JpaUserDetailsService;

@Configuration
@EnableWebSecurity
class SecurityConfig(val jpaUserDetailsService : JpaUserDetailsService) {
    @Bean
    fun configure(http : HttpSecurity) : SecurityFilterChain =
        http
            .csrf().disable() // disable cross site request forgery
            .authorizeRequests()
                //allow everyone to see the landing pages
                .antMatchers(
                    "/",
                    "/about",
                    "/app",
                    "/signUp",
                    "/contact",
                    "/landing/css/*", //enable all css
                    "/landing/js/*", //enable all js
                    "/landing/img/*", //enable all images
                    "/favicon.ico",
                    "/api/user",
                ).permitAll()
                .anyRequest().authenticated()
            .and()
            .userDetailsService(jpaUserDetailsService)
            .httpBasic()
            .and().build();

    @Bean
    fun passwordEncoder() : PasswordEncoder = BCryptPasswordEncoder();
}

data class Message(val message : String) //this class is used to send back messages to front-end as an object