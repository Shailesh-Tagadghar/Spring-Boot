package com.example.demo.many_to_many;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Book.class})
public interface BookProjection {
	String getTitle();
	List<Author> getAuthors();
	int getPrice();
}

//http://localhost:8080/books/1?projection=bookProjection //---to get the single details in Postman using like this //to get details by ID();
