package com.Springboot.BookReviewApplication.configuration;

import com.Springboot.BookReviewApplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {


    @Autowired
    private UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // 🔹 Disable CSRF (important for Postman testing)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/register", "/users/login", "/reviews/**").permitAll() // 🔹 Allow access to these APIs
                        .anyRequest().authenticated()  // 🔹 Other endpoints require authentication
                )
                .formLogin(login -> login.disable())  // 🔹 Disable default Spring Security login form
                .httpBasic(basic -> basic.disable()); // 🔹 Disable basic authentication (optional)

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
}
}

