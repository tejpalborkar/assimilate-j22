package com.assimilate.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	static SessionFactory sessionFactory;

	static {
		sessionFactory = new Configuration().configure("hibernate-cfg.xml").buildSessionFactory();

		System.out.println("Session factory created");

	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
