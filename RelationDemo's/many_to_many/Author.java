package com.example.demo.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	
	private String name;
	
	private String quali;
	
	@ManyToMany(mappedBy = "authors")
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public String getName() {
		return name;
	}

	public String getQuali() {
		return quali;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuali(String quali) {
		this.quali = quali;
	}
	
	
}
