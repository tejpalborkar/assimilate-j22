package com.assimilate.loginapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.assimilate.loginapp.database.UserDboperations;
import com.assimilate.loginapp.model.User;

public class UserService {

	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();

		UserDboperations userDb =new UserDboperations();
		
		userList = userDb.getAllUsers();
		
		return userList;
	}

	public User getUser() {

		User user = new User();
		user.setFirstName("Tejpal");
		user.setLastName("Borkar");
		user.setMobileNumber("1234567");

		return user;

	}
	
	public static void main(String[] args) {
		UserService userService  = new UserService();
		List<User> users = userService.getUsers();
		
		for (User user : users) {
			System.out.println(user);
		}
	}
}
