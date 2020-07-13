package com.assimilate.ems.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.assimilate.ems.model.Employee;

public class UserDbOperations {

	public Employee findUserByUserNameAndPassword(String userName, String password) {

		Connection connection = DatabaseConnection.getConnection();
		String query = "select * from employee where username =? AND password=?";
		try {
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAge(resultSet.getString("age"));
				employee.setUserName(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				return employee;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
