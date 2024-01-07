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
	// it only supports -- findAll() method
	// we can create custom method as well into this
	
	// save, deleteById, findById this methods also has 
	
	
}


// by using this link you can set size of pages that you want to check
// http://localhost:8080/users?size=2
// this will provid eyou this para in this end of postman
//     "page": {
//       "size": 2,
//       "totalElements": 6,
//        "totalPages": 3,
//        "number": 0
//    }

// it will also provide you the links to visit next and last pages
'''
"_links": {
        "first": {
            "href": "http://localhost:8080/users?page=0&size=2"
        },
        "self": {
            "href": "http://localhost:8080/users?page=0&size=2"
        },
        "next": {
            "href": "http://localhost:8080/users?page=1&size=2"
        },
        "last": {
            "href": "http://localhost:8080/users?page=2&size=2"
        },
        "profile": {
            "href": "http://localhost:8080/profile/users"
        }
    } 
'''
//like this


// to sort the records by asec order
// http://localhost:8080/users?sort=name

// to sort the records by desc order
// http://localhost:8080/users?sort=name,desc

// we can sort by any fields using and or operator
// http://localhost:8080/users?size=1&sort=name,desc
// http://localhost:8080/users?page=5&size=1&sort=name,desc
