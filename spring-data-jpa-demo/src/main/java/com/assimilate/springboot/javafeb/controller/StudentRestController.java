package com.assimilate.springboot.javafeb.controller;

import java.util.List;
import java.util.Optional;

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

import com.assimilate.springboot.javafeb.model.Student;
import com.assimilate.springboot.javafeb.repository.StudentRepository;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping
	public List<Student> getAllStudents() {
		List<Student> studets = studentRepository.findAll();
		return studets;
	}

	@PostMapping
	public Student create(@RequestBody Student student) {
		return studentRepository.save(student);
	}

	@DeleteMapping("/{studentId}")
	public String delete(@PathVariable("studentId") Integer studentId) {
		studentRepository.deleteById(studentId);
		return "Ok";
	}

	@PutMapping("/{studentId}")
	public Student update(@PathVariable("studentId") Integer studentId,@RequestBody Student student) {
		student.setId(studentId);
		return studentRepository.save(student);
	}

	@GetMapping("/{studentId}")
	public Student findById(@PathVariable("studentId") Integer studentId) {
		Optional<Student> optional = studentRepository.findById(studentId);
		return optional.orElseGet(null);
	}

	
	@GetMapping("/search")
	public List<Student> getAllStudentsByName(@RequestParam("mobile") String mobile) {
		List<Student> studets = studentRepository.findByMobile(mobile);
		return studets;
	}
}
