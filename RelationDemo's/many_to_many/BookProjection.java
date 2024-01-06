package com.example.demo.many_to_many;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Book.class})
public interface BookProjection {
	String getTitle();
	List<Author> getAuthors();
	int getPrice();
}
