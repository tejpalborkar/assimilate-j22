package com.assimilate.springboot.javafeb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assimilate.springboot.javafeb.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	
	List<Student> findByRollNo(String rollNo);
	
	List<Student> findByFirstNameAndLastName(String firstName, String lastName);
	
	



}
