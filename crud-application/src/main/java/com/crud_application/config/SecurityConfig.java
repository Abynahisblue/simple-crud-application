package com.crud_application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF if it's not needed
                .csrf(csrf -> csrf.disable())
                // Allow all requests
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                // Optionally configure other security features if needed
                 .httpBasic(withDefaults())
                .logout(withDefaults());  // Enable logout functionality if needed

        return http.build();
    }
}