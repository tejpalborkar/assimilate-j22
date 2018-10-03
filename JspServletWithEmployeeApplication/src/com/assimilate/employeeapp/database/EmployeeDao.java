package com.assimilate.employeeapp.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.assimilate.employeeapp.model.Employee;

public class EmployeeDao {

	public int save() {
		try {

			Connection connection = DbConnection.getConnection();

			String query = "INSERT INTO employee (first_name, last_name, mobile_number, user_name, password) values ( 'Govind', 'Gaikwad', '1234567', 'govind', 'govind' )";

			Statement stmt = connection.createStatement();
			int rowsAffected = stmt.executeUpdate(query);

			System.out.println("Rows inserted: " + rowsAffected);
			return rowsAffected;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Employee save(String firstName, String lastName, String mobile, String userName, String password) {
		try {

			Connection connection = DbConnection.getConnection();

			String query = "INSERT INTO employee (first_name, last_name, mobile_number, user_name, password) values ( '"
					+ firstName + "', '" + lastName + "','" + mobile + "','" + userName + "','" + password + "')";
			System.out.println(query);

			Statement stmt = connection.createStatement();
			int rowsAffected = stmt.executeUpdate(query);

			System.out.println("Rows inserted: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployee(String userName, String password) {
		System.out.println("Executing get employee");
		try {
			Connection connection = DbConnection.getConnection();
			String query = "SELECT * FROM employee where user_name = '" + userName + "' AND password ='" + password
					+ "'";

			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);

			Employee employee = null;
			while (rs.next()) {
				employee = new Employee();
				String userNameFromDb = rs.getString("user_name");
				String passwordFromDb = rs.getString("password");
				String firstNameFromDb = rs.getString("first_name");
				String lastNameFromDb = rs.getString("last_name");
				String mobileFromDb = rs.getString("mobile_number");
				employee.setUserName(userNameFromDb);
				employee.setPassword(passwordFromDb);
				employee.setFirstName(firstNameFromDb);
				employee.setLastName(lastNameFromDb);
				employee.setMobileNumber(mobileFromDb);
			}

			if(employee == null) {
				System.out.println("Employee not exist in db with userName : "+userName);
			}else {
				System.out.println("Employee exist in db with userName : "+userName);
			}
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int save(Employee employee) {
		try {

			Connection connection = DbConnection.getConnection();

			String query = "INSERT INTO employee (first_name, last_name, mobile_number, user_name, password) values ( '"
					+ employee.getFirstName() + "', '" + employee.getLastName() + "','" + employee.getMobileNumber()
					+ "','" + employee.getUserName() + "','" + employee.getPassword() + "')";
			System.out.println(query);

			Statement stmt = connection.createStatement();
			int rowsAffected = stmt.executeUpdate(query);

			System.out.println("Rows inserted: " + rowsAffected);
			return rowsAffected;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public List<Employee> getAllEmployees() {
		System.out.println("Executing get All employees");
		List<Employee> employees = Collections.emptyList();
		try {

			Connection connection = DbConnection.getConnection();
			String sqlQuery = "SELECT * FROM Employee";

			Statement statement = connection.createStatement();

			ResultSet resultset = statement.executeQuery(sqlQuery);

			employees = iterateResultSet(resultset);

			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	/**
	 * table - > employee columns -> first_name, last_name, user_name, password
	 * 
	 */
	private List<Employee> iterateResultSet(ResultSet resultset) {
		List<Employee> employees = new ArrayList<>();

		try {
			while (resultset.next()) {

				String firstName = resultset.getString("first_name");
				String lastName = resultset.getString("last_name");

				String mobileNumber = resultset.getString("mobile_number");
				String userName = resultset.getString("user_name");
				String password = resultset.getString("password");

				Employee emp = new Employee();

				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setPassword(password);
				emp.setUserName(userName);
				emp.setMobileNumber(mobileNumber);

				System.out.println("Employee from DB: " + emp);
				employees.add(emp);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employees;
	}

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		// dao.save();
		// dao.save("Jyotiram", "dewalkar", "909075839475", "jyoti", "pwd");

		Employee employee = new Employee();
		employee.setFirstName("Appa 2");
		employee.setLastName("undre");
		employee.setMobileNumber("123456");
		employee.setPassword("pwd");
		employee.setUserName("appa");

		// dao.save(employee);

		Employee employeeFromDb = dao.getEmployee("tejpal", "tejpal");
		System.out.println(employeeFromDb);

		// List<Employee> employeesFromDb = dao.getAllEmployees();
		// System.out.println("Employee count () :" + employeesFromDb.size());

	}

}
