package com.assimilate.springboot.javafeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.javafeb.dao.StudentDao;
import com.assimilate.springboot.javafeb.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

	@RequestMapping(value = "/students")
	public List<Student> students() {
		return studentDao.findAll();
	}

	// Add student
	// Retrieve Student, -( byname, by id, by mobile no)
	// delete the student
	// view all students.

	// HTTP method
	// POST -> Create a resource
	// PUT -> Update the existing resource
	// Delete -> Delete the existing resource
	// GET -> Retrieve the resources from the server.

	// Add student:
	// Json student (Request Body) (payload)
	// URL pattern: /students/
	// Request Method: POST

	// Delete a student
	// need a id with request
	// URL pattern: /students/{id}
	// method: DELETE

	// Student controller -> Create Student

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String creatStudent(@RequestBody Student student) {
		studentDao.save(student);
		return "OK";

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public Student findById(@PathVariable(name = "id") Integer id) {
		return studentDao.findById(id);
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public String deleteStudent(@PathVariable(name = "id") Integer id) {
		studentDao.delete(id);
		return "Student deleted";
	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
	public Student update(@PathVariable(name = "id") Integer id, @RequestBody Student student) {
		student.setId(id);
		studentDao.update(student);
		return student;
	}

}
