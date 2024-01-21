package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.Employee;

@CrossOrigin(origins = "*",maxAge = 5000, allowCredentials = "false") //this will remove cors error in console
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
  
}
