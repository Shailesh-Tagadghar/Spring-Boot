package com.example.demo.one_to_many;



public interface UserProjection {
	String getName();
	int getId();
	Blogs getBlogs();
}
