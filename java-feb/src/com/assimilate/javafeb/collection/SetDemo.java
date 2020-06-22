package com.assimilate.javafeb.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.assimilate.javafeb.accessmodifires.Employee;

public class SetDemo {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();
		boolean added = set.add("abc");
		System.out.println("Added: " + added);

		added = set.add("abc");
		System.out.println("Added: " + added);

		set.add("abcd");
		set.add("1234");
		System.out.println("Size: " + set.size());

		System.out.println(set);
		for (String value : set) {
//			System.out.println(value);
		}

		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
		linkedHashSet.add("abc");
		linkedHashSet.add("abcd");
		linkedHashSet.add("1234");

		System.out.println(linkedHashSet);

		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		treeSet.add(100);
		treeSet.add(50);
		treeSet.add(250);
		treeSet.add(150);
		System.out.println("Tree set:");
		System.out.println(treeSet);

		Comparator<Employee> employeeComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.getId() - o2.getId();
			}
		};

		Set<Employee> employeeSet = new TreeSet<Employee>(employeeComparator);

		employeeSet.add(new Employee(110, "Tejpal"));
		employeeSet.add(new Employee(100, "Saurabh"));
		employeeSet.add(new Employee(105, "Jaypal"));
		employeeSet.add(new Employee(103, "Dinesh"));
		employeeSet.add(new Employee(104, "Mayuri"));

		System.out.println("Employees::");
		System.out.println(employeeSet);

	}
}
