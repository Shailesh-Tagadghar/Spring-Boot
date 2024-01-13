package com.example.SecurityDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	// 1. All Public url's
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> {
			auth.anyRequest().permitAll();
		});
		
		
		return http.build();
	}
	
	// 2. All Private url's
	// 3. Some Public and Private url's (Partial Url's)
	// 4. In Memory User
	
}
