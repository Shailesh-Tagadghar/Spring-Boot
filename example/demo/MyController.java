package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		myService.login();
		
		return "welcome to login page";
	}

	
}
