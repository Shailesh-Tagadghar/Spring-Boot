package com.example.demo.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.User;

//public interface UserRepository extends JpaRepository<User, Integer>
public interface UserRepository extends PagingAndSortingRepository<User, Integer>{
	
	// JpaRepository : -
	// is used for same as CrudRepository to perform CRUD operation and some different operation 
	// -- this operation present in JpaRepository
	
	// PagingAndSortingRepository :-
	// to perform paging and sorting operation
	// default has findAll() method
	// we can create custom method as well into this
	
	// save, deleteById, findById this methods also has 
	
	
}
