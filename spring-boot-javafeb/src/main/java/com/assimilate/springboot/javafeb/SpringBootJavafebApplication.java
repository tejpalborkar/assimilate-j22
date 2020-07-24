package com.assimilate.springboot.javafeb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Controller;

import com.assimilate.springboot.javafeb.dao.StudentDao;
import com.assimilate.springboot.javafeb.model.Employee;
import com.assimilate.springboot.javafeb.model.Student;

//Annotation
@SpringBootApplication
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class })
public class SpringBootJavafebApplication  {

	@Autowired
	private Employee employee;

	@Autowired
	private StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavafebApplication.class, args);

	}
	/*
	 * @Override public void run(String... args) throws Exception { Student student
	 * = new Student(); student.setFirstName("John"); student.setLastName("Cena");
	 * student.setMobile("879879879"); student.setRollNo(234324);
	 * student.setCourse("EnTc"); studentDao.save(student);
	 * 
	 * List<Student> students = studentDao.findAll();
	 * 
	 * students.forEach(studentFromDb -> { System.out.println(studentFromDb); });
	 * 
	 * // studentDao.delete(3);
	 * 
	 * System.out.println("Student by id: 4");
	 * System.out.println(studentDao.findById(4));
	 * 
	 * }
	 */

}
