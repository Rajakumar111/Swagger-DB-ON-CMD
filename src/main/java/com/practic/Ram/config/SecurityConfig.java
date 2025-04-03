package com.practic.Ram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // httpSecurity.csrf().disable().cors().disable();  -depricated
        http.csrf(csrf->csrf.disable()).cors(cors->cors.disable());
//        http.authorizeHttpRequests();
        return http.build();

    }
}
