package com.example.demo.models;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {Employee.class},name = "employeeProjection")
public interface EmployeeProjection {
	String getName();
	String getEmail();
	String getDept();
	int getId();
	int getSalary();
}
