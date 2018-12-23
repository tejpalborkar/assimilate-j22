package com.assimilate.loginapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static final String url = "jdbc:mysql://localhost:3306/assimilate_dec18";
	public static final String user = "root";
	public static final String password = "root";

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Db Connection successful");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

}
