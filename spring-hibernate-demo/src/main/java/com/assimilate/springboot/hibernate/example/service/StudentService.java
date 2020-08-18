package com.assimilate.springboot.hibernate.example.service;

import java.util.List;

import com.assimilate.springboot.hibernate.example.model.Student;

public interface StudentService {
	public Student save(Student student);

	public Student update(Student student);

	public List<Student> findAll();

	public Student findById(Long studentId);

	public void deleteById(Long studentId);

}
