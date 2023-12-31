package com.example.demo.one_to_one;

import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
//this is employee interface to create table into database and to interact with database 
}
