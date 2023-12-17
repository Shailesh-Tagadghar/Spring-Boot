package com.example.demo;

import org.springframework.beans.BeanWrapperImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMachValidator implements ConstraintValidator<PassMatchValid, Object> {
	
	String field;
	String matchingField;
	
	
	
	@Override
	public void initialize(PassMatchValid constraintAnnotation) {
		this.field = constraintAnnotation.field();
		this.matchingField = constraintAnnotation.matchingField();
	}



	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object matchingFieldValue = new BeanWrapperImpl(value).getPropertyValue(matchingField);
		
		return fieldValue.equals(matchingFieldValue);
	}
	
}
