package com.example.SecurityDemo;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.SecurityDemo.Models.User;
import com.example.SecurityDemo.Repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//1. bring the user object from database based on email
		
		User dbUser = userRepository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Email Id"));
		
		//2. create the new UserDetails Object with email, password, authorities
		
		User authUser = new User(
				dbUser.getEmail(),
				dbUser.getPassword(),
				dbUser.getRoles()
				      .stream()
				      .map(role -> new SimpleGrantedAuthority(role))
				      .collect(Collectors.toList())
				);
		
		return authUser;
	}

}
