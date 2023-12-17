package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

//1. Validation logic implemented by class
@Constraint(validatedBy = PasswordMachValidator.class)

//2. where we can use this annotation
@Target({ ElementType.TYPE})  //Type : is applicable on class (it is class level annotation)

//3. when the validation should work
@Retention(RetentionPolicy.RUNTIME)

public @interface PassMatchValid {
	String message() default "Password must match";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String field();
	String matchingField();
}
