package com.assimilate.springboot.javafeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.javafeb.dao.StudentDao;
import com.assimilate.springboot.javafeb.model.Student;

@RestController
public class StudentController {

	@Autowired
	StudentDao studentDao;

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

	// HTTP STATUS
	// 2xx -> 200, 201, 202, ... Successful operation
	// 3xx -> Redirection
	// 4xx -> client error
	// 400 -> Bad request (json is incorrect)
	// 401 -> Unuthorzied (usernmae/passsord is incorrect, jwt expired)
	// 404 -> Resource not foud ( url is incorrect or resource not available for
	// given criteria or id)

	// 5xx -> 500, 502, -> Internal server error, 502 service not.
	// /xyz -> redirects /abc 3xx, 302

	@RequestMapping(value = "/students")
	public List<Student> students() {
		return studentDao.findAll();
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public String creatStudent(@RequestBody Student student) {
		studentDao.save(student);
		return "OK";

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable(name = "id") Integer id) {
		Student student = studentDao.findById(id);

		ResponseEntity<?> studedntResponse = null;

		if (student != null) {
			studedntResponse = new ResponseEntity<Student>(student, HttpStatus.OK);
		} else {
			studedntResponse = new ResponseEntity<String>("Student not found with id: "+id, HttpStatus.NOT_FOUND);
		}
		return studedntResponse;

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

	@RequestMapping(value = "/students/search", method = RequestMethod.GET)
	public Student search(@RequestParam(name = "rollNo", required = false) Integer rollNo,
			@RequestParam(name = "firstName", required = false) String firstName,
			@RequestParam(name = "mobile", required = false) String mobile) {
		return studentDao.search(rollNo, firstName, mobile);
	}

}
