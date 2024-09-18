package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .csrf().disable() // Disable CSRF for simplicity; consider enabling it in production
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // Allow access to auth endpoints without authentication
                .anyRequest().authenticated() // Secure other endpoints
            )
            .httpBasic(); // Enable basic authentication

        // Configure CORS
        httpSecurity.cors();

        return httpSecurity.build();
    }

    
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	System.out.println("command reached in cors configure");
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000") // Add more origins if necessary
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*") // Allow all headers
                        .exposedHeaders("Authorization") // Allow frontend to read this header
                        .allowCredentials(true); // Handle cookies and credentials, if needed
            }
        };
    }

}
