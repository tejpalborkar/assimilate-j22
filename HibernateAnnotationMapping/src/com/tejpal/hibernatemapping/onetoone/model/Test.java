package com.tejpal.hibernatemapping.onetoone.model;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;

import com.tejpal.hibernatemapping.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();
		
		Employee employee = new Employee();
		employee.setFirstName("Tejpal");
		employee.setLastName("Borkar");
		employee.setCellPhone("9097234234");
		employee.setBirthDate(new Date(System.currentTimeMillis()));
		
		EmployeeDetail employeeDetail = new EmployeeDetail();
		employeeDetail.setCountry("India");
		employeeDetail.setState("Maharashtra");
		employeeDetail.setCity("Pune");
		
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);

		session.saveOrUpdate(employeeDetail);
		session.beginTransaction().commit();
		System.out.println("Employee added");
		
		
//		Employee employeeFromDb = (Employee) session.get(Employee.class, 2);
//		System.out.println(employeeFromDb);
//		System.out.println(employeeFromDb.getEmployeeDetail());
//		
//		
//		employeeFromDb.setFirstName("Salman");
//		employeeFromDb.setLastName("Khan");
//		
//		employeeFromDb.getEmployeeDetail().setCity("Mumbai");
		
	//	session.saveOrUpdate(employeeFromDb);
		session.beginTransaction().commit();
		
//		session.delete(employeeFromDb);
//		session.beginTransaction().commit();
//		System.out.println("Employee deleted");
		
		// HQL-> Hibernate Query language
		// sql -> select * from employee;
		
//		List<Employee> list = session.createQuery("from Employee where firstName='Tejpal'").list();
//		
//		for (Employee employee2 : list) {
//			System.out.println(employee2);
//		}
		
		
		EmployeeDetail empDetails = (EmployeeDetail)session.get(EmployeeDetail.class, 3);
		System.out.println(empDetails);
		System.out.println(empDetails.getEmployee());
		
	
		
		session.delete(empDetails);
		session.beginTransaction().commit();
	}

}
