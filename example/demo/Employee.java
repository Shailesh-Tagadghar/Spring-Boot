package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Employee {
	@NotNull 
	private int id;
	
	@NotNull @NotEmpty @Size(min = 3, max = 10)
	private String name;
	
	@NotNull @NotEmpty
	private String dept;
	
	@NotNull @Min(value = 10000) @Max(value = 80000)
	private int salary;
	
	@NotNull @NotEmpty 
	@Pattern(regexp = "[8,9]{1}[0-9]{9}")
	@Size(min=10, max=10, message="Num must be 10 no. long")
	private String mobile;
	
	@NotNull
	@Email @ItvEmail
	private String Email;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + ", mobile=" + mobile
				+ ", Email=" + Email + "]";
	}
	
	
}
