package com.assimilate.javafeb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public Connection getConnection() {
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

	public void readTable() {

		Connection connection = getConnection();
		String query = "select * from employee";

		Statement statement;
		try {
			statement = connection.createStatement();

			// execute query and get the resultset
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Id: " + resultSet.getInt("id"));
				System.out.println("Name: " + resultSet.getString("name"));
				System.out.println("Age: " + resultSet.getInt("age"));
				System.out.println("-----------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// interact with the database. you can

		// to store the data..
		// to process that data we need to write the program.

		// FB -> Datastore, web application,

		// A

		// Step : you download a jar jdbc jar -> jar in build path
		// load the driver class
		// Create the connection objecct by using Driver

		JdbcTest jdbcTest = new JdbcTest();
		
		//jdbcTest.readTable();
		//jdbcTest.readTable("Tejpal");
		
		//jdbcTest.insertEmployee();
//		jdbcTest.updateEmployee(4, "Shahrukh", 50);
		
//		System.out.println("After insert..");
		jdbcTest.readTable();
		
		jdbcTest.deleteEmployee("Shahrukh");
	}
	
	public void readTable(String name) {

		Connection connection = getConnection();
//		String query = "select * from employee where name = 'Tejpal'";
		String query = "select * from employee where name =?";

		Statement statement;
		try {
//			statement = connection.createStatement();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, name);

			// execute query and get the resultset
			ResultSet resultSet = pstmt.executeQuery(query);

			while (resultSet.next()) {
				System.out.println("Id: " + resultSet.getInt("id"));
				System.out.println("Name: " + resultSet.getString("name"));
				System.out.println("Age: " + resultSet.getInt("age"));
				System.out.println("-----------------");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertEmployee() {
		
		Connection connection = getConnection();
		
		//insert into employee values(2, 'Json', 24)

		// Avoid any sql injections, DML
		String sql  = "insert into employee values(?,?,?)";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, 4);
			prepareStatement.setString(2, "Sameer");
			prepareStatement.setInt(3, 30);
			
			int rowsInserted = prepareStatement.executeUpdate();
			
			System.out.println("Records inserteed: "+rowsInserted);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
private void updateEmployee(int id, String name, int age) {
		
		Connection connection = getConnection();
		
		//insert into employee values(2, 'Json', 24)

		// Avoid any sql injections, DML
		String sql  = "update employee set name=?, age=? where id=?";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, age);
			prepareStatement.setInt(3, id);
			
			int rowsInserted = prepareStatement.executeUpdate();
			
			System.out.println("Records updated: "+rowsInserted);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

private void deleteEmployee(String name) {
	
	Connection connection = getConnection();
	
	//insert into employee values(2, 'Json', 24)

	// Avoid any sql injections, DML
	String sql  = "delete from employee where name =?";
	try {
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		prepareStatement.setString(1, name);
		
		int rowsInserted = prepareStatement.executeUpdate();
		
		System.out.println("Records deleted: "+rowsInserted);
		
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

}
