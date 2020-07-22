package com.assimilate.springboot.javafeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Annotation
@SpringBootApplication
public class SpringBootJavafebApplication implements CommandLineRunner{

	@Autowired
	private Employee employee;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavafebApplication.class, args);
		System.out.println("Application stopped..");
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application runnig..");
		System.out.println(employee.getName());
		
		System.out.println(employee.getAddress());
	}

}
