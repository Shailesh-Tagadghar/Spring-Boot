package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Employee;


@RepositoryRestResource(excerptProjection = EmployeeProjection.class)
public interface EmployeeReository extends CrudRepository<Employee, Integer> {

}
//this file is for to connect with or interact with database, table
