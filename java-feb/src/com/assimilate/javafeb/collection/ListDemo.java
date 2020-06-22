package com.assimilate.javafeb.collection;

import java.util.ArrayList;
import java.util.List;

import com.assimilate.javafeb.accessmodifires.Employee;

public class ListDemo {
	public static void main(String[] args) {
//Generics
		List<String> list1 = new ArrayList<>();
		list1.add("ABC");
		list1.add("ABCD");
		list1.add("XYZ");

//		list.add(1234);
//		
//		list.add(new Employee(123, "Test"));

		// retrive

//		Integer value = (Integer) list.get(1);
//		System.out.println(value);
//
//		Employee emp = (Employee) list.get(2);

//		System.out.println(emp);
		System.out.println("Iterating using array..");
		for (int i = 0; i < list1.size(); i++) {

//			Object obj = list.get(i);

//			if (obj instanceof String) {
//				String str = (String) obj;
//				System.out.println(str);
//			}
//
//			if (obj instanceof Integer) {
//				Integer val = (Integer) obj;
//				System.out.println(val);
//			}
//
//			if (obj instanceof Employee) {
//				Employee val = (Employee) obj;
//				System.out.println(val);
//			}

//			String str = list.get(0);
//			System.out.println(str);

		}
		list1.add("ABC");
		list1.add("ABCD");
		list1.add("XYZ");

		System.out.println(list1);
		System.out.println(list1.contains("ABC"));
		System.out.println(list1.indexOf("ABCD"));
		System.out.println(list1.isEmpty());
		System.out.println(list1.lastIndexOf("ABCD"));
//		System.out.println(list.remove(5));
//		System.out.println(list.remove("ABCD"));
		
		List<String> list2 = new ArrayList<String>();
		list2.add("ABC");
		list2.add("XYZ");
		list2.add("MNQ");
		System.out.println(list1.removeAll(list2));
		System.out.println(list1);
		list1.addAll(list2);
		System.out.println(list1);
		
		list1.retainAll(list2);
		System.out.println(list1);
		
		
		
		
		
	}
}
