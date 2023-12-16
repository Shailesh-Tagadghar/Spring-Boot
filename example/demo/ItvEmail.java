package com.example.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;

//1. Validation logic implemented by class
@Constraint(validatedBy = ItvEmailValidator.class)

//2. where we can use this annotation
@Target({ ElementType.FIELD})

//3. when the validation should work
@Retention(RetentionPolicy.RUNTIME)

public @interface ItvEmail {

}
