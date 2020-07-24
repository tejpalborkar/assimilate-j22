package com.assimilate.springboot.javafeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.javafeb.dao.StudentDao;
import com.assimilate.springboot.javafeb.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@RequestMapping(value = "/helloWorld")
	public String helloWorld() {
		System.out.println("Executing hello world");
		return "hellow";
	}

	@RequestMapping(value = "/welcome")
	public String welcome() {
		System.out.println("Executing welcome");
		return "Welcome Tejpal";
	}

	@RequestMapping(value = "/students")
	public List<Student> students() {
		return studentDao.findAll();
	}

}
