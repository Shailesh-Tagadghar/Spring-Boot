package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	//custom search query methods - lookups
	
	//for single user email
	public Optional<User> findByEmail(String email);
	
	//for multiple user name
	public Iterable<User> findAllByName(String name);
	
	//using logical operators - AND || &&
	public Optional<User> findByEmailAndPassword(String email, String password);
	
}

//to search by email :- http://localhost:8080/users/search/findByEmail?email=sat@gmail.com
//to search by name :- http://localhost:8080/users/search/findAllByName?name=sat
//to search by AND logical operator :- http://localhost:8080/users/search/findByEmailAndPassword?email=sat@gmail.com&&password=sat@123
