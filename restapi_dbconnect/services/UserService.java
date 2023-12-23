package com.restapi_dbconnect.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
	
	public User getById(int id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Id"));
		return user;
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		User updatedUser = userRepository.save(user);
		return updatedUser;
	}
}
