package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class MyController {
	
	@Autowired
	private MyService myService;

	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping("/home")
	public String index() {
		System.out.println(appName);
		return "Welcome from "+appName;
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("Calling service class logins");
//		myService.login();
		return "welcome to login page";
	}

	@PostMapping("/addemp")
	public String addEmployee(@RequestBody @Valid Employee employee) {
//		System.out.println(employee);
		myService.addEmp(employee);
		
		return "Employee added Successfully !";
	}
	
	@PutMapping("/updateemp")
	public String updateEmployee(@RequestBody Employee employee) {
		myService.updateEmp(employee);
		return "Employee Updated Successfully !";
	}
	
	@DeleteMapping("/deleteemp")
	public String deleteEmployee(@RequestParam("id") int id) {
		System.out.println("this Id is going to delete id = "+id);
		myService.deleteEmp(id);
		return "Employee deleted Successfully !";
	}
	
	@GetMapping("/emplist")
	public Iterable<Employee> getAllEmployees(){
		Iterable<Employee> allEmp = myService.getAll();
		return allEmp;
	}
	
	//localhost:8090/getemp?id=105
//	@GetMapping("/getemp")
//	public Employee getById(@RequestParam("id") int id) {
//		Employee e = myService.getById(id);
//		return e;
//	}
	
	//localhost:8090/getemp/105
	@GetMapping("/getemp/{id}")
	public Employee getbyId(@PathVariable int id) {
		Employee e  = myService.getById(id);
		return e;
	}
	
	
	
}
