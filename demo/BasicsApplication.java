package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner{

	// 1. field injection
	@Autowired
	private Students students;
	@Autowired
	private Scanner scanner;
	
	// 2. Constructor injection 
//	private Students students;
//	
//	@Autowired
//	public BasicsApplication(Students students) {
//		this.students = students;
//	}
	
	// 3. Setter injection
//	private Students students;
//	@Autowired
//	public void setStudents(Students students) {
//		this.students = students;
//	}
	
	// we can use any injection method but spring uses 1st Field Injection Method because its popular way 
	
	public static void main(String[] args) { 
		SpringApplication.run(BasicsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		students.study();
		System.out.println("Plase Enter the Name : ");
		String name = scanner.next();
		System.out.println("Welcome "+name + " !");
	}
	
}
