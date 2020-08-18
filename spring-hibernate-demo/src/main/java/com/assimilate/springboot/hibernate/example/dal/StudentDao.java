package com.assimilate.springboot.hibernate.example.dal;

import java.util.List;

import com.assimilate.springboot.hibernate.example.model.Student;

public interface StudentDao {

	public Student save(Student student);

	public Student update(Student student);

	public Student delete(Student student);

	public List<Student> findAll();

	public Student findById(Long studentId);

}
