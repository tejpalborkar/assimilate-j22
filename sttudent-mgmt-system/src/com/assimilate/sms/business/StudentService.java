package com.assimilate.sms.business;

import com.assimilate.sms.dao.StudentDao;
import com.assimilate.sms.model.Student;

public class StudentService {

	public Student register(Student student) {

		StudentDao studentDao = new StudentDao();
		int result = studentDao.save(student);
		return student;

	}

	public void delete(int studentId) {
		StudentDao studentDao = new StudentDao();
		studentDao.delete(studentId);
		System.out.println("Student deleted successully..");
	}

	public void update(Student student) {
		StudentDao studentDao = new StudentDao();
		studentDao.update(student);
	}

}
