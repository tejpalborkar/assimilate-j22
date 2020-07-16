package com.assimilate.sms.service;

import com.assimilate.sms.model.Student;
import com.assimilate.sms.model.User;

public class ValidationUtil {

	public static boolean validateStudent(Student student) {
		
		if(student.getFirstName()==null || student.getFirstName().isEmpty() ) {
			return false;
		}
		
		if(student.getLastName()==null || student.getLastName().isEmpty() ) {
			return false;
		}
		
		return true;
		
	}

	public static boolean validateUser(User user, String confirmPassword) {
		if(user.getPassword() == null || confirmPassword == null || user.getPassword().isEmpty() || 
				confirmPassword.isEmpty()) {
			//not valid
			return false;
		}
		
		if(user.getUserName() == null  || user.getUserName().isEmpty() || 
				confirmPassword.isEmpty()) {
			//not valid
			return false;
		}
		if( ! confirmPassword.equals(user.getPassword())) {
			return false;
		}
		return true;
	}

}
