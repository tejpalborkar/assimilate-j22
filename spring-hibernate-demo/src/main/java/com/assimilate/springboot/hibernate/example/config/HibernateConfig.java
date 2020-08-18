package com.assimilate.springboot.hibernate.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class HibernateConfig {

	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {

		System.out.println("Initializing session factory with dataSource: " + dataSource);
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.assimilate.springboot.hibernate.example.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		System.out.println("Session factory initiated");
		return sessionFactory;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		hibernateProperties.setProperty("show_sql", "true");

		return hibernateProperties;
	}

	@Bean
	@Autowired
	public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

}
