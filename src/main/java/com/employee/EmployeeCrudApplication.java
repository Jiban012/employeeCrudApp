package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		System.out.println("flow    &&&&&&&   start");
		SpringApplication.run(EmployeeCrudApplication.class, args);
		System.out.println("flow    &&&&&&&   ddd");
	}

}
