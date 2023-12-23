package com.restapi_dbconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi_dbconnect.models.User;
import com.restapi_dbconnect.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public Iterable<User> getAll(){
		Iterable<User> allUsers = userRepository.findAll();
		return allUsers;
	}
	
}
