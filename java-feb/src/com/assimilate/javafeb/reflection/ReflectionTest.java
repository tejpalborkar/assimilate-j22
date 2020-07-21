package com.assimilate.javafeb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	public static void main(String[] args) throws InstantiationException {
		try {
			
			
			Class companyClass = Class.forName("com.assimilate.javafeb.reflection.Company");
			Object newInstance = companyClass.newInstance();
			
			
			Method[] methods = companyClass.getDeclaredMethods();
			System.out.println(methods.length);
			for (Method method : methods) {
				System.out.println(method.getName());
				
				method.setAccessible(true);
//				System.out.println("Is Accessible: "+method.isAccessible());
				method.invoke(newInstance);
				
			}
			
			Constructor[] declaredConstructors = companyClass.getDeclaredConstructors();
			
			for (Constructor constructor : declaredConstructors) {
				System.out.println(constructor.getName());
			}
			
			Field[] declaredFields = companyClass.getDeclaredFields();
			for (Field field : declaredFields) {
				System.out.println(field.getName());
				field.setAccessible(true);
			}

		} catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}

}
