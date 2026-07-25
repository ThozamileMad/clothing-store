package com.thozamile.shopbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                request -> 
                    request
                        .requestMatchers("/users/sign_up", "/users/sign_in").permitAll()
                        .requestMatchers("/admin/**").hasRole("admin")
                        .requestMatchers("/users/**").authenticated()
                        .anyRequest().permitAll()
            )
            .httpBasic(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /* 
    @Bean 
    UserDetailsService testOnlyUsers(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder();

        UserDetails thaboNkosi = 
            users
                .username("ThaboNkosi")
                .password(passwordEncoder.encode("ThaboNkosi@2"))
                .roles("admin")
                .build();

        UserDetails LeratoDlamini = 
            users  
                .username("LeratoDlamini")
                .password(passwordEncoder.encode("LeratoDlamini@2"))
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(thaboNkosi, LeratoDlamini);
    }
    */
}
