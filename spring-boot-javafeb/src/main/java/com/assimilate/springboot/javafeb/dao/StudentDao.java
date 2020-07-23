package com.assimilate.springboot.javafeb.dao;

import java.util.List;

import com.assimilate.springboot.javafeb.model.Student;

public interface StudentDao {

	public void save(Student student);

	public void update(Student student);

	public void delete(Integer studentId);

	public List<Student> findAll();

	public void findById(Integer id);

}
