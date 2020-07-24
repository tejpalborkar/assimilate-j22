package com.assimilate.springboot.javafeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	

	@RequestMapping(value="/helloWorld")
	public String helloWorld() {
		System.out.println("Executing hello world");
		return "Welcome to assimilate";
	}
	
	@RequestMapping(value="/welcome")
	public String welcome() {
		System.out.println("Executing welcome");
		return "Welcome Tejpal";
	}

}
