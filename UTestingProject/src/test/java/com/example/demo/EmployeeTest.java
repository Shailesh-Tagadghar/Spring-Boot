package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
	
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void addEmployeeTest() {
		Employee e = new Employee();
//		e.setName("Amit");
//		e.setDept("IT");
//		e.setSalary(8000);
		
		e.setName("Shailesh");
		e.setDept("CS");
		e.setSalary(12000);
		Employee obj = repository.save(e);
		
		assertNotNull(obj);
	}
}
