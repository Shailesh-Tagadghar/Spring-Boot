package com.example.SecurityDemo.Registration;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SecurityDemo.Models.User;
import com.example.SecurityDemo.Models.UserDTO;
import com.example.SecurityDemo.Repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;

	public void registerUser(UserDTO userdto) {
		
		//Steps to create service class
		// 1. Receive UserDTO object 
		// 2. Create User object
		// 3. Call the save() the repository
		
		User user = new User();
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		//password must be encrypted
		user.setPassword(encoder.encode(userdto.getPassword()));
		
		//to give role based access to the user
		if(userdto.getRoles()==null)
			user.setRoles(Arrays.asList("ROLE_USER"));
		else
			user.setRoles(userdto.getRoles());
		
		userRepository.save(user);
		
	}

}
