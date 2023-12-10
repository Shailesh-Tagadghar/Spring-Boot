package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class MyService {
	
//	public void login() {
//		System.out.println("Within service login");
//	}
	
	private Map<Integer,Employee> allemployees =
			new HashMap<>();
	
	//insert 
	public void addEmp(Employee employee) {
		allemployees.put(employee.getId(),employee);
		System.out.println(allemployees);
	}
	
	//update 
	public void updateEmp(Employee employee) {
		allemployees.put(employee.getId(),employee);
		System.out.println(allemployees);
	}
	
	//delete
	public void deleteEmp(int id) {
		allemployees.remove(id);
	}

	
}
