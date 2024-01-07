package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// Default query methods :
	// CRUD Repository provides basic operations
	// 1. findById(id)
	// 2. findAll
	// 3. deleteById(id)
	// 4. save()

	//custom search query methods - lookups
	
	//for single user email
	public Optional<User> findByEmail(String email);
	
	//for multiple user name
	public Iterable<User> findAllByName(String name);
	
	//using logical operators - AND || &&
	public Optional<User> findByEmailAndPassword(String email, String password);

	//like operator
	public Iterable<User> findByNameContaining(String name);

	//Order By Ascending
	@RestResource(path = "asc-name") 
	// to set custom link name //we don't have to write the whole -- findAllByOrderByNameAsc();
	public Iterable<User> findAllByOrderByNameAsc();
	
}

//to search by email :- http://localhost:8080/users/search/findByEmail?email=sat@gmail.com
//to search by name :- http://localhost:8080/users/search/findAllByName?name=sat
//to search by AND logical operator :- http://localhost:8080/users/search/findByEmailAndPassword?email=sat@gmail.com&&password=sat@123
//to search by Like Operator % :- http://localhost:8080/users/search/findByNameContaining?name=at
//to search by Order By Operator % :- http://localhost:8080/users/search/findAllByOrderByNameAsc
//or 
//                        http://localhost:8080/users/search/asc-name
