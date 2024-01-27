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
	//@Disabled //to skip this test case
	@Order(1) // to set order of execution
	public void addEmployeeTest() {
		Employee e = new Employee();
	     // this test case will be failed due to salary>=10000
	     //	e.setName("Amit");
	     //	e.setDept("IT");
	     // e.setSalary(8000);

		//this test case will pass 
		e.setName("Shailesh");
		e.setDept("CS");
		e.setSalary(12000);
		Employee obj = repository.save(e);
		assertNotNull(obj);
	}


	@Test
	@Order(2)
	public void updateEmployee() {
		Employee e = repository.findById(1).orElseThrow(()-> new NullPointerException("The test case is failed !!"));
		e.setDept("Computer Science");
		e.setSalary(26000);
                Employee obj = repository.save(e);
		assertNotNull(obj);
				
	}
}
