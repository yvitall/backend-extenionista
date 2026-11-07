package com.yvitall.ubs_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita a proteção CSRF (necessário para aceitar POST do frontend)
                .csrf(csrf -> csrf.disable())
                // Permite que o frontend acesse a API (CORS)
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(auth -> auth
                        // Libera o seu endpoint de agendamento para qualquer pessoa
                        .requestMatchers("/api/agendamento").permitAll()
                        // Qualquer outra rota continua exigindo login
                        .anyRequest().authenticated());
        return http.build();
    }
}