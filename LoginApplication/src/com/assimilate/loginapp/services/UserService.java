package com.assimilate.loginapp.services;

import java.util.Collections;
import java.util.List;

import com.assimilate.loginapp.model.User;

public class UserService {

	public List<User> getUsers() {
		return Collections.emptyList();
	}

	public User getUser() {

		User user = new User();
		user.setFirstName("Tejpal");
		user.setLastName("Borkar");
		user.setMobileNumber("1234567");

		return user;

	}
}
