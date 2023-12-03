package com.example.demo;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanDemo {
	@Bean
	public LocalDate localDate() {
		System.out.println("Local Date been created !");
		return LocalDate.now();
	}
	
	@Bean
	public Scanner scanner() {
		System.out.println("Scanner been created !");
		return new Scanner(System.in);
		}
}
