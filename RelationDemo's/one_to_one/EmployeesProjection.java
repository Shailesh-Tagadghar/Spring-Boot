package com.example.demo.one_to_one;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = {EmployeesProjection.class})
public interface EmployeesProjection {
	String getName();
	String getDept();
	int getId();
	int getSalary();
	Address getAddress();
}
