package com.assimilate.springboot.javafeb.dao;

import java.util.List;

import com.assimilate.springboot.javafeb.model.Student;

public interface StudentDao {

	public int save(Student student);

	public int update(Student student);

	public int delete(Integer studentId);

	public List<Student> findAll();

	public Student findById(Integer id);

	public Student findByRollNo(Integer rollNo);

	public Student search(Integer rollNo, String firstName, String mobile);

}
