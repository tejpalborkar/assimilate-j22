package com.assimilate.sms.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.assimilate.sms.model.User;

public class UserDao {

	public User findUserByUserName(String userName, String password) {
		Connection connection = DatabaseConnection.getConnection();
		String query = "select * from user where username =? AND password=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setUserId(resultSet.getInt("user_id"));
				user.setPassword(resultSet.getString("password"));
				user.setRole(resultSet.getString("role"));
				user.setUserName(resultSet.getString("username"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean insertUser(User user) {
		Connection connection = DatabaseConnection.getConnection();
		String sql = "insert into user(username,password,role) values(?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, user.getUserName());
			prepareStatement.setString(2, user.getPassword());
			prepareStatement.setString(3, user.getRole());
			int executeUpdate = prepareStatement.executeUpdate();
			System.out.println("Student inserted: " + executeUpdate);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
