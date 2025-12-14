package com.example.myproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Spring Configuration class
@EnableMethodSecurity(securedEnabled = false) // Enable method-level security
public class SecurityConfiguration {


    @Bean // Define BCryptPasswordEncoder as a Spring Bean
    public PasswordEncoder passwordEncoder() { // Bean for password encoding
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth.anyRequest().permitAll()) // allow everything
        .formLogin(form -> form.disable()) // disable login page
        .httpBasic(basic -> basic.disable()); // disable basic auth
    return http.build();
}
}