package com.assimilate.loginapp.services;

import java.util.ArrayList;
import java.util.List;

import com.assimilate.loginapp.database.EmployeeDbOperations;
import com.assimilate.loginapp.model.Employee;

public class EmployeeService {

	private List<Employee> employees;

	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<>();

		EmployeeDbOperations employeeDbOperations = new EmployeeDbOperations();
		employees= employeeDbOperations.retriveAll();
		this.employees = employees;
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
