package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public String addEmployee(@RequestBody Employee employee) {
//		System.out.println(employee);
		myService.addEmp(employee);
		
		return "Employee added Successfully !";
	}
	
	@PutMapping("/updateemp")
	public String updateEmployee(@RequestBody Employee employee) {
		myService.updateEmp(employee);
		return "Employee Updated Successfully !";
	}
	
}
