package com.assimilate.hibernate.manytoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.assimilate.hibernate.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("OMR Road", "Chennai", "TN", "600097");
//By using cascade=all option the address need not be saved explicitly when the student object is persisted the address will be automatically saved.
			// session.save(address);
			Student student1 = new Student("Eswar", address);
			
			Student student2 = new Student("Joe", address);
			
			session.save(student1);
			session.save(student2);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		session = HibernateUtil.getSession();
		Student studentFromDb  =session.get(Student.class, 1L);
		System.out.println(studentFromDb);
		
//		session.delete(studentFromDb);
		session.beginTransaction().commit();
	}
}