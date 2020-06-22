package com.assimilate.javafeb.accessmodifires;

class Parent {
	int getSalary() {
		return 100;
	}

}

class Child extends Parent {

	protected int getSalary() {
		return 1000;
	}
}

public class TestMain {

	public static void main(String[] args) {
		Parent c = new Child();
		System.out.println();
	}
}
