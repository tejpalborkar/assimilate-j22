package com.assimilate.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Driver {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("spring-context.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		System.out.println("Container initialized");

		//IoC
		
		Student student = (Student) beanFactory.getBean("studentBean");
	
		//new 
		
//		Student st = new Student();
		
		
		// Reflection
		
		System.out.println(student);
		System.out.println(student);

	}

}
