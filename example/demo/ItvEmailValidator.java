package com.example.demo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ItvEmailValidator implements ConstraintValidator<ItvEmail, String> {
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		boolean result = email.endsWith("@itvedant.com");
		return result;
	}
}
