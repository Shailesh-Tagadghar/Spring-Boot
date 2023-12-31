package com.example.demo.one_to_one;

import org.springframework.data.repository.CrudRepository;

@RepositoryRestResource(excerptProjection = EmployeesProjection.class)
public interface EmployeesRepository extends CrudRepository<Employees, Integer> {
//this is employee interface to create table into database and to interact with database 
}
