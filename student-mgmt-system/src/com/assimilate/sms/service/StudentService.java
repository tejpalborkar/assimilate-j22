package com.assimilate.sms.service;

import java.util.List;

import com.assimilate.sms.dal.StudentDao;
import com.assimilate.sms.model.Student;

public class StudentService {

	public void createStudent(Student student) {
		StudentDao studentDao = new StudentDao();
		studentDao.insertStudent(student);
		
	}

	public List<Student> getAllStudents() {
		StudentDao studentDao = new StudentDao();
		return studentDao.fetchAllStudents();
	}

}
