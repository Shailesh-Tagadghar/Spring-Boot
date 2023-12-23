package com.restapi_dbconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restapi_dbconnect.models.User;
import com.restapi_dbconnect.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users")
	public String adduser(@RequestBody User user) {
		userService.addUser(user);
		return "User SeccessFully Added ! ";
	}
	
	@GetMapping("/users")
	public Iterable<User> getAll(){
		Iterable<User> allUsers = userService.getAll();
		return allUsers;
	}
	
	@GetMapping("/users/{id}")
	public User getbyId(@PathVariable int id) {
		User user = userService.getById(id);
		return user;
	}

	@DeleteMapping("/users/{id}")
	public void delUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
