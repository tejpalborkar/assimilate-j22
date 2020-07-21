package com.assimilate.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("spring-context.xml");
		
		// Lazy container
//		System.out.println("Initializing ioc container..");
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
//		System.out.println("Container initialized");
//		
//		System.out.println("Getting student bean from ioc container");
//		Student student = (Student) beanFactory.getBean("studentBean");
//		System.out.println(student);
//		
		
		
		//Eager container
		System.out.println("Initializing ioc eager container..");
		ApplicationContext context =   new ClassPathXmlApplicationContext("spring-context.xml");  
		System.out.println("ApplicationContext IOC Container initialized");

		Student stu= (Student)context.getBean("studentBean");
		System.out.println(stu);
		
		Student stu2= (Student)context.getBean("studentBean2");
		System.out.println(stu2);
		
		
		Student stu3= (Student)context.getBean("studentBean3");
		System.out.println(stu3);
		
		System.out.println(context.getBean("studentBean4"));
	
	
		//IoC
		
		
		
		//new 
		
//		Student st = new Student();
		
		
		// Reflection
		

	}

}
