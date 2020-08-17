package com.assimilate.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

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

			Set<Course> courses = new HashSet<Course>();
			courses.add(new Course("Maths"));
			courses.add(new Course("Computer Science"));

			Student student1 = new Student("Eswar", courses);
			Student student2 = new Student("Joe", courses);
			
			session.save(student1);
			session.save(student2);

			session.flush();
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		
		session = HibernateUtil.getSession();
		
		Student studentFromDb= session.get(Student.class, 1L);
		System.out.println(studentFromDb);
		
		session.delete(studentFromDb);
		session.beginTransaction().commit();
		
	}
}