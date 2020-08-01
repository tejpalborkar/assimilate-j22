package com.assimilate.springboot.javafeb.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ApplicationConfiguration {

//	@Bean
//	public DataSource dataSource() {
//		DriverManagerDataSource ds = new DriverManagerDataSource();
//		String url = "jdbc:mysql://localhost:3306/java_feb";
//		ds.setUrl(url);
//		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		ds.setUsername("tejpal");
//		ds.setPassword("tejpal");
//		System.out.println("datasource bean initialized");
//		return ds;
//	}
//
//	@Bean
//	@Autowired
//	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//		System.out.println("jdbc template initialized.");
//		return jdbcTemplate;
//	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
//	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/views/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	

}
