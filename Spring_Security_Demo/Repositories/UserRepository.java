package com.example.SecurityDemo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.SecurityDemo.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

   // TO Disable PUT and POST Method for User Entity
  @RestResource(exported = false)
	public User save(User user);
  
}
