package com.assimilate.ems.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	/**
	 * Creates the connection and returns
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class is loaded..");

			// Install mysql, create user and password
			//

			// create connection, connection url,
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_feb", "tejpal",
					"tejpal");

			System.out.println("Connection is successfull...");
			return connection;

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
