package com.assimilate.loginapp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.assimilate.loginapp.model.User;

public class UserService {

	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();

		User user1 = new User();
		user1.setFirstName("Bhavna");
		user1.setLastName("Mahajan");
		user1.setMobileNumber("902845092475");

		User user2 = new User();
		user2.setFirstName("Gayatri");
		user2.setLastName("Bhamare");
		user2.setMobileNumber("7983798273");

		User user3 = new User();
		user3.setFirstName("Ankita");
		user3.setLastName("Khollam");
		user3.setMobileNumber("73265776857");

		userList.add(user1);
		userList.add(user2);
		userList.add(user3);

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
