package com.assimilate.sms.service;

import com.assimilate.sms.dal.UserDao;
import com.assimilate.sms.model.User;

public class UserService {

	public User verfyLogin(String userName, String password) {
		UserDao userDao = new UserDao();
		return userDao.findUserByUserName(userName, password);
	}

	public User createUser(User user) {
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		return user;

	}

}
