package com.example.demo;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@Disabled // it is class level as well
class UnitTestingProjectApplicationTests {

	@Test
	//@Disabled //to disabled specific test case
	void contextLoads() {
		System.out.println("It says all clear go for development !!");
	}

}
