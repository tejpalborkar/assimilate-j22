package com.assimilate.springboot.javafeb;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.stereotype.Controller;

import com.assimilate.springboot.javafeb.dao.StudentDao;
import com.assimilate.springboot.javafeb.dao.StudentRepository;
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

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavafebApplication.class, args);

	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Student student = new Student();
//		student.setFirstName("Salman");
//		student.setLastName("Khan");
//		student.setMobile("8798798790");
//		student.setRollNo(234324);
//		student.setCourse("EnTc");
//	
////		studentDao.save(student);
////
////		List<Student> students = studentDao.findAll();
//
//
//		// studentDao.delete(3);
////
////		System.out.println("Student by id: 4");
////		System.out.println(studentDao.findById(4));
//
////		Student studentInserted = studentRepository.save(student);
////		System.out.println(studentInserted);
//
//		List<Student> studentsFromDb = studentRepository.findAll();
//		
////
////		studentsFromDb.forEach(studentFromDb -> {
////			System.out.println(studentFromDb);
////		});
//
//		long totalRecords = studentRepository.count();
//		
//		System.out.println("Total records in the table: "+totalRecords);
//		
//		Optional<Student> studentById = studentRepository.findById(23);
//		studentById.ifPresent(stu -> {
//			System.out.println(stu);
//		});
//		
//		
//		List<Student> findByFirstName = studentRepository.findByFirstName("Salman");
//		System.out.println(findByFirstName);
//		
//		List<Student> findByLastName = studentRepository.findByLastName("Khan");
//		System.out.println(findByLastName);
//		
//	}

}
