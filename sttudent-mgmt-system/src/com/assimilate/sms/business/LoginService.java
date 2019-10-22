package com.assimilate.sms.business;

import com.assimilate.sms.dao.StudentDao;
import com.assimilate.sms.model.Student;

public class LoginService {

	
	public Student validateStudent(String userName, String password) {
		System.out.println("Executing validateStudent");
		StudentDao studentDao =new StudentDao();
		Student student = studentDao.getStudentByEmailNameAndPassword(userName, password);
		return student;
	}
}
