package com.assimilate.javafeb.oops;

class Car {

	int stearing = 100;
	int clutch = 200;
	String name = "";

	public void drive() {
		System.out.println(name + " Car driving ");
	}

	public void applyBreak() {
		System.out.println(name + "applying break");
	}

	private void drink() {
		System.out.println("I m drinking");
	}

}

class Bmw extends Car {

	public Bmw() {
		name = "BMW";
		System.out.println(name + " Constructor invoked ");
	}

	public void drink() {
		System.out.println("I am also drinking..");
	}

}

class Mercedez extends Car {

	public Mercedez() {
		name = "Mercedez";
		System.out.println(name + " Constructor invoked ");
	}
}

class AutomaticCar extends Car {

	@Override
	public void drive() {
		System.out.println("Automatically driving");
	}

	// Method overloading compile time polymorphism
	public void sum(int a, int b) {
		System.out.println("a + b : " + (a + b));
	}

	public void sum(int a, int b, int c) {
		System.out.println("a + b + c: " + (a + b + c));
	}

	public void sum(float a, int b) {
		System.out.println("a + b : " + (a + b));
	}

}

public class InheritenceDemo {

	public static void main(String[] args) {
		/*
		 * Bmw bmw = new Bmw(); bmw.drive();
		 * 
		 * Mercedez mercedez = new Mercedez(); mercedez.drive();
		 */

		// Runtime polymorphism / dynamic binding
		AutomaticCar autoCar = new AutomaticCar();
		autoCar.drive();
//		autoCar.drink();
//		Bmw bmw = new Bmw();
//		bmw.drive();
		autoCar.sum(10, 20);

		// compile time polymorphism / static binding
		autoCar.sum(1.3f, 20);

		// upcasting
		Car bmw = new Bmw();

		// downcasting
//		Bmw newbmw =(Bmw)  new Car();
		
		
		Bmw newBmw = (Bmw) bmw;
		
		bmw.drive();

		Car car = new Car();
		
//		car.drink();

		car.drive();

	}

}
