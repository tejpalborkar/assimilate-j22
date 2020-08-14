package com.assimilate.hibernate.onetoone;

import org.hibernate.Session;

import com.assimilate.hibernate.Employee;
import com.assimilate.hibernate.HibernateUtil;

public class TestOnetoOne {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		System.out.println("session created.");

		Employee employee = new Employee();
		employee.setName("Tejpal Borkar");
		employee.setMobile("234234234234");
		employee.setDepartment("Dev");

		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setCountry("India");
		employeeAddress.setState("Maharashtra");
		employeeAddress.setCity("Pune");

		employee.setEmployeeAddress(employeeAddress);

		session.save(employee);
		
		session.beginTransaction().commit();
		System.out.println("Employee saved: " + employee);
//		
		Employee employeeFromDb = session.get(Employee.class, 2);
//		
		System.out.println(employeeFromDb);
		System.out.println(employeeFromDb.getEmployeeAddress());

	}
}
