package com.zorkmaster.demo11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation -> these are SPRING BEANS(beans === single instance of X)
@SpringBootApplication
public class Demo11Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo11Application.class, args);
	}

}
