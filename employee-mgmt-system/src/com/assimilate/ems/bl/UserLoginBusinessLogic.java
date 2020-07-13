package com.assimilate.ems.bl;

import com.assimilate.ems.db.UserDbOperations;
import com.assimilate.ems.model.Employee;

public class UserLoginBusinessLogic {

	public boolean validateUser(String userName, String password) {
	
//		if (userName.equals("tejpal") && password.equals("tejpal")) {
//			return true;
//		} else {
//			return false;
//		}
		
		UserDbOperations userDbOperations = new UserDbOperations();
		
		Employee employeeFromDb = userDbOperations.findUserByUserNameAndPassword(userName, password);
		if(employeeFromDb == null) {
			return false;
		}else {
			return true;
		}
		
	}

}
