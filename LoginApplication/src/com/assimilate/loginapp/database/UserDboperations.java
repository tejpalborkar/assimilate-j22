package com.assimilate.loginapp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.assimilate.loginapp.model.User;

public class UserDboperations {

	public User getUserByUserName(String userName, String password) {

		Connection connection = DbConnection.getConnection();
		try {

			String sqlQuery = "SELECT * FROM user where user_name =? AND password =?";

			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);

			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();

			while (resultSet.next()) {

				Integer userId = resultSet.getInt("user_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String mobileNumber = resultSet.getString("mobile_number");
				String passwordFromDb = resultSet.getString("password");
				String userNameFromDb = resultSet.getString("user_name");

				System.out.println("Id: " + userId);
				System.out.println("first Name: " + firstName);
				System.out.println("Mobile: " + mobileNumber);

				System.out.println("==============================================");

				User user = new User();

				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setMobileNumber(mobileNumber);
				user.setPassword(password);
				user.setUserName(userNameFromDb);
				user.setUserId(userId);

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public List<User> getAllUsers() {

		List<User> userList = new ArrayList<>();
		Connection connection = DbConnection.getConnection();
		try {

			String sqlQuery = "SELECT * FROM user";

			Statement stmt = connection.createStatement();

			ResultSet resultSet = stmt.executeQuery(sqlQuery);

			while (resultSet.next()) {

				Integer userId = resultSet.getInt("user_id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String mobileNumber = resultSet.getString("mobile_number");
				String passwordFromDb = resultSet.getString("password");
				String userNameFromDb = resultSet.getString("user_name");

				System.out.println("Id: " + userId);
				System.out.println("first Name: " + firstName);
				System.out.println("Mobile: " + mobileNumber);

				System.out.println("==============================================");

				User user = new User();

				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setMobileNumber(mobileNumber);
				user.setPassword(passwordFromDb);
				user.setUserName(userNameFromDb);
				user.setUserId(userId);

				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return userList;

	}

	public static void main(String[] args) {
		UserDboperations userDboperations = new UserDboperations();
		User user = userDboperations.getUserByUserName("tejpal", "1234");

	}

	public void insert(String userName, String password, String firstName, String lastName, String mobileNumber) {

		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO user(first_name, last_name, mobile_number, user_name, password) values (?,?,?,?,?)");

			pstmt.setString(1, firstName);
			pstmt.setString(2, lastName);
			pstmt.setString(3, mobileNumber);
			pstmt.setString(4, userName);
			pstmt.setString(5, password);

			int rowCount = pstmt.executeUpdate();

			if (rowCount <= 0) {
				System.out.println("No rows are inserted");
			} else {
				System.out.println(rowCount + " row inserted successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
