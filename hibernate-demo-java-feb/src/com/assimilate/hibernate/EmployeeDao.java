package com.assimilate.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeDao {

	public Employee save(Employee employee) {

		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		session.close();
		System.out.println("Employee saved");
		return employee;

	}
	
	private Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

		//TODO implement logic to update employee
		return employee;
	}
	
	// delete
	// retrieve

}
