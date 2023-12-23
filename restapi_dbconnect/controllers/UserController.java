package com.restapi_dbconnect.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi_dbconnect.models.User;
import com.restapi_dbconnect.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
//	@PostMapping("/users")
	@PostMapping("")
	public String adduser(@RequestBody User user) {
		userService.addUser(user);
		return "User SeccessFully Added ! ";
	}
	
//	@GetMapping("/users")
	@GetMapping("")
	public Iterable<User> getAll(){
		Iterable<User> allUsers = userService.getAll();
		return allUsers;
	}
	
//	@GetMapping("/users/{id}")
	@GetMapping("/{id}")
	public User getbyId(@PathVariable int id) {
		User user = userService.getById(id);
		return user;
	}
	
//	@PutMapping("/users/{id}")
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable int id) {
		user.setId(id);
//		System.out.println("User id to be updated : "+user.getId());
		User updatedUser = userService.updateUser(user);
		return updatedUser;
	}
	
//	@DeleteMapping("/users/{id}")
	@DeleteMapping("/{id}")
	public void delUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
	
}
