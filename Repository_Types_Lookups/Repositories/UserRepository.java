package com.example.demo.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findByEmail(String email);
	
}
