package com.assimilate.springboot.javafeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoApplication.class, args);
	}
	
	// Basic Authentication
	// Username password authentication -> (in memory user name and password or credentials stored in the db.)
	// REST -> basic auth, oauth ( JWT token ) 
	
	// 4xx -> client side error
	
	// 401 -> Unauthorized -> u have to pass the credentials along with your request. 

}
