package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
	
	@Autowired
	private EmployeeRepository repository;
	
	//	@Test
////	@Disabled //to skip this test case
//	@Order(1) // to set order of execution
//	public void addEmployeeTest() {
//		Employee e = new Employee();
//		e.setName("Amit");
//		e.setDept("IT");
//		e.setSalary(8000);
//		Employee obj = repository.save(e);
//		assertNotNull(obj);
//	}
	
	@Test
	@Order(1)
	public void addEmployeeTest1() {
		Employee e = new Employee();
		e.setName("Radhika");
		e.setDept("Shop");
		e.setSalary(40000);
		Employee obj = repository.save(e);
		assertNotNull(obj);
	}
	
	@Test
	@Order(2)
	public void addEmployeeTest2() {
		Employee e = new Employee();
		e.setName("Ashok");
		e.setDept("Garment");
		e.setSalary(25000);
		Employee obj = repository.save(e);
		assertNotNull(obj);
	}


	@Test
	@Order(3)
	public void updateEmployee() {
		Employee e = repository.findById(1).orElseThrow(()-> new NullPointerException("The test case is failed !!"));
		e.setDept("Computer Science");
		e.setSalary(26000);
        Employee obj = repository.save(e);
		assertNotNull(obj);		
	}

	@Test
	@Order(4)
	public void findAllTest() {
		List<Employee> emp = (List<Employee>) repository.findAll();
		int actualCount = emp.size();
		int expectedCount = 3;
		assertEquals(expectedCount, actualCount);
	}
}
