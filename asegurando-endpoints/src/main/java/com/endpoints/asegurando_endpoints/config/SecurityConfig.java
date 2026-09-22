package com.endpoints.asegurando_endpoints.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Vista y estilos públicos
                .requestMatchers("/", "/index.html", "/styles.css").permitAll()
                // Endpoint público
                .requestMatchers("/gfg/welcome").permitAll()
                // Endpoint protegido
                .requestMatchers("/gfg").authenticated()
                // Cualquier otro endpoint
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
            )
            .httpBasic(basic -> {});

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails usuario = User.builder()
            .username("gfg")
            .password(passwordEncoder.encode("gfg123"))
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(usuario);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}