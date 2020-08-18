package com.assimilate.springboot.hibernate.example.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.hibernate.example.model.Student;
import com.assimilate.springboot.hibernate.example.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public List<Student> getAllStudents() {
		List<Student> studets = studentService.findAll();
		return studets;
	}

	@PostMapping
	public Student create(@RequestBody Student student) {
		return studentService.save(student);
	}

	@DeleteMapping("/{studentId}")
	public String delete(@PathVariable("studentId") Long studentId) {
		studentService.deleteById(studentId);
		return "Ok";
	}

	@PutMapping("/{studentId}")
	public Student update(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
		student.setId(studentId);
		return studentService.update(student);
	}

	@GetMapping("/{studentId}")
	public Student findById(@PathVariable("studentId") Long studentId) {
		Student student = studentService.findById(studentId);
		return student;
	}

	@GetMapping("/search")
	public List<Student> getAllStudentsByName(@RequestParam("mobile") String mobile) {
//		List<Student> studets = studentService.findByMobile(mobile);
//		return studets;
		return Collections.emptyList();
	}
}
