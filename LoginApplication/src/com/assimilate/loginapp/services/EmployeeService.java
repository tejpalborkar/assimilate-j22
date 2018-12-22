package com.assimilate.loginapp.services;

import java.util.ArrayList;
import java.util.List;

import com.assimilate.loginapp.model.Employee;

public class EmployeeService {

	private List<Employee> employees;

	public List<Employee> getEmployees() {

		List<Employee> employees = new ArrayList<>();

		Employee emp1 = new Employee();
		emp1.setEmployeeId(1);
		emp1.setName("Tejpal Borkar");
		emp1.setSalary(100000);
		emp1.setDepartment("Development");

		Employee emp2 = new Employee();
		emp2.setEmployeeId(2);
		emp2.setName("Bhavna Mahajan");
		emp2.setSalary(10000);
		emp2.setDepartment("Development");

		employees.add(emp1);
		employees.add(emp2);
		this.employees = employees;
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
