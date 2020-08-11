package com.assimilate.hibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {

		// SessionFactory -> provides the session object
		
		// Session -> save, update, delete, select
		
		// connection -> 
		
		SessionFactory sessionFactory = new Configuration().
				configure("hibernate-cfg.xml").buildSessionFactory();
		
		System.out.println("Session factory created");
		
		Session session = sessionFactory.openSession();
		System.out.println("Session created");
		
		Employee employee = new Employee();
		employee.setName("John");
		employee.setMobile("98687679");
		employee.setDepartment("QA");
		
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.save(employee);
		
//		Transaction transaction = session.beginTransaction();
//		session.save(employee);
//		transaction.commit();
	//	System.out.println("employee saved. "+employee);
		
		
//		Employee employeeFromDb = session.get(Employee.class, 2);
//		
//		System.out.println("Empl from db: "+employeeFromDb);
//		
//		Employee employee2FromDb = session.get(Employee.class, 1);
//		
//		System.out.println("Empl from db: "+employee2FromDb);
//		
//		
//		Employee employeeFromDbUsingLoad = session.load(Employee.class, 3);
//	
//		System.out.println(employeeFromDbUsingLoad);
		
		// delete a record of id 1
		
		Integer id = 1;
//		Employee employeeTobeDeleted = session.get(Employee.class, id);
//		
//		Transaction beginTransaction = session.beginTransaction();
//		session.delete(employeeTobeDeleted);
//		beginTransaction.commit();
//		System.out.println("employee deleted with id : "+id);
//		
		
		
		Employee employeeTobeUpdated = session.get(Employee.class, 2);
		
		employeeTobeUpdated.setName("Tejpal");
		session.saveOrUpdate(employeeTobeUpdated);
		session.beginTransaction().commit();
		
		
		session.close();
		sessionFactory.close();
		
		
		
	}

}
