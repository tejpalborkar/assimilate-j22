package com.assimilate.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static final String url = "jdbc:mysql://localhost:3306/assimilate_dec18";
	public static final String user = "root";
	public static final String password = "root";

	public Connection getConnection() {
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

	public void retrive() {
		Connection connection = getConnection();
		try {

			Statement statement = connection.createStatement();

			String sqlQuery = "SELECT * FROM employee";
			ResultSet resultSet = statement.executeQuery(sqlQuery);

			while (resultSet.next()) {

				Integer id = resultSet.getInt("employee_id");
				String employeeName = resultSet.getString("employee_name");
				Integer salary = resultSet.getInt("salary");
				String department = resultSet.getString("department");

				System.out.println("Id: " + id);
				System.out.println("Employee Name: " + employeeName);
				System.out.println("Salary: " + salary);
				System.out.println("Department: " + department);

				System.out.println("==============================================");
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

	}

	public void insert(String name, Integer salary, String department) {

		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("INSERT INTO employee(employee_name, salary, department) values (?,?,?)");

			pstmt.setString(1, name);
			pstmt.setInt(2, salary);
			pstmt.setString(3, department);

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

	public void update(Integer employeeId, Integer salary, String department) {

		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con
					.prepareStatement("UPDATE employee SET salary = ?, department = ? where employee_id  =?");

			pstmt.setInt(1, salary);
			pstmt.setString(2, department);
			pstmt.setInt(3, employeeId);

			int rowCount = pstmt.executeUpdate();

			if (rowCount <= 0) {
				System.out.println("No rows are updated");
			} else {
				System.out.println(rowCount + " row updated successfully");
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

	public void delete(Integer employeeId) {

		Connection con = getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("DELETE from employee where employee_id = ?");

			pstmt.setInt(1, employeeId);

			int rowCount = pstmt.executeUpdate();

			if (rowCount <= 0) {
				System.out.println("No rows are deleted");
			} else {
				System.out.println(rowCount + " row deleted successfully");
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

	public static void main(String[] args) {

		JdbcTest test = new JdbcTest();
		test.retrive();
		// test.insert("Bhavna", 19000, "Testing");
//		test.update(4, 60000, "Production");
		test.delete(89);
		System.out.println("Latest Records");
		test.retrive();
	}
}
