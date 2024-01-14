package com.example.SecurityDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	// 1. All Public url's
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf(csrf->csrf.disable())
//		.authorizeHttpRequests(auth -> {
//			auth.anyRequest().permitAll();
//		});
//		
//		
//		return http.build();
//	}
	
	// 2. All Private url's -- by using this method we have to use custom username and password that we created in resource file
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf(csrf->csrf.disable())
//		.authorizeHttpRequests(auth -> {
//			auth.anyRequest().authenticated();
//		}).httpBasic(Customizer.withDefaults());
//		
//		
//		return http.build();
//	}
	
	// 3. Some Public and Private url's (Partial Url's)
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		
//		http.csrf(csrf->csrf.disable())
//		.authorizeHttpRequests(auth -> {
//			auth.requestMatchers(HttpMethod.GET,"/users").authenticated()
//			    .requestMatchers(HttpMethod.GET,"/users/**").authenticated()
//			    .requestMatchers(HttpMethod.PUT,"/users/**").authenticated()
//			    .anyRequest().permitAll();
//		}).httpBasic(Customizer.withDefaults());
//		
//		
//		return http.build();
//	}
	
	// 4. In Memory Use 
	// a. Role Based access -- Some Public and Private url's 
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(auth -> {
			auth.requestMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
			    .requestMatchers(HttpMethod.GET,"/users/**").hasRole("USER")
			    .requestMatchers(HttpMethod.PUT,"/users/**").hasRole("USER")
			    .anyRequest().permitAll();
		}).httpBasic(Customizer.withDefaults());
		
		
		return http.build();
	}
	
	//b. In memory use -- to create custom user and password to access
	@Bean
	public UserDetailsService detailsService() {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails user1 = User.withUsername("user1")
				.password(encoder.encode("user1"))
				.roles("USER")
				.build();
		
		UserDetails user2 = User.withUsername("admin1")
				.password(encoder.encode("admin1"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2);
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
