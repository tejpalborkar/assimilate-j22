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

	public Employee save(Employee employee) {
		try {

			Connection connection = DbConnection.getConnection();

			return employee;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> getAllEmployees() {
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
				String userName = resultset.getString("user_name");
				String password = resultset.getString("password");

				Employee emp = new Employee();

				emp.setFirstName(firstName);
				emp.setLastName(lastName);
				emp.setPassword(password);
				emp.setUserName(userName);

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
		List<Employee> employeesFromDb = dao.getAllEmployees();

	}
}
