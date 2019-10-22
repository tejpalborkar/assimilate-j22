package com.assimilate.sms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded");

			String connectionUrl = "jdbc:mysql://localhost:3306/assimilate_db";
			String userName = "tejpal";
			String password = "tejpal";

			Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
			System.out.println("Connection created successfully....");
			return connection;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Conneciton not created");
		return null;

	}
	
	public static void main(String[] args) {
		getConnection();
	}

}
