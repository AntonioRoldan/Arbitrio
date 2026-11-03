package com.example.Arbitrio.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter){
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll() // Público para todos
                        .requestMatchers("/api/legal/**").hasRole("LEGAL_ADMIN")
                        .requestMatchers("/api/finance/**").hasRole("FINANCE_ADMIN")
                        .requestMatchers("/api/company/**").hasRole("COMPANY_ADMIN")
                        .requestMatchers("/api/procurement/**").hasRole("PROCUREMENT_MANAGER")
                        .requestMatchers("/api/vendor/**").hasRole("VENDOR_ADMIN") // The vendor sending a signed contract and accepting the delivery of a service also sending a bill
                        // Solo para administradores
                        .anyRequest().authenticated() // Cualquier otra ruta requiere estar logueado
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
