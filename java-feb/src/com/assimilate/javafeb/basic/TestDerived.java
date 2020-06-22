package com.assimilate.javafeb.basic;

import com.assimilate.javafeb.accessmodifires.Employee;

public class TestDerived extends Employee {
	public static void main(String[] args) {
		TestDerived d = new TestDerived();
		d.id = 1000;
		
		d.mobile = "98798";
		
	}
}
