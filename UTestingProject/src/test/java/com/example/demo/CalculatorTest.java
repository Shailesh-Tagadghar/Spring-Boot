package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class CalculatorTest {
	
private Calculator c = new Calculator();

   //test case	
	
    @Test
	public void testAddNum() {
		int actualAnswer = c.addNum(10,20);
		int expectedAnswer = 30;
		
		assertEquals(expectedAnswer, actualAnswer, "Addition test case failed !!");
	}
	
}
