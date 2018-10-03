package com.assimilate.employeeapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String URL = "jdbc:mysql://localhost:3306/employee_db";
	public static final String DB_USER = "root";
	public static final String PASSWORD = "root";

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(URL, DB_USER, PASSWORD);

			System.out.println("DB connection successfull");

			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println("Driver not found.. Please check if the mysql-connector is added in build path");
			e.printStackTrace();
			throw e;
		}

	}
	
	public static void main(String[] args) throws Exception {
		DbConnection.getConnection();
		
	}
}
