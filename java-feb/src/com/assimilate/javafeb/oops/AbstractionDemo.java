package com.assimilate.javafeb.oops;

interface BaseInterface {
	static int a = 1000;

	public void applyBreak();
}

class GrandBase {

	int a;

	public GrandBase() {
		System.out.println("Executing GrandBase class constructor");
	}

	public void method1() {
		System.out.println("executing method 1");
	}

}

abstract class Base extends GrandBase {

	int a;

	public Base(int a, int b) {
		this.a = a;
		System.out.println("Executing Base class constructor");
	}

	public void method1() {
		System.out.println("executing method 1");
	}

	public abstract void method2();

}

class Derived extends Base implements BaseInterface {

	int b;
	int c;

	public Derived(int a, int b, int c) {

		super(a, b);
		System.out.println("Derived class constructor executing");
		this.b = b;
		this.c = c;
		System.out.println("Derived class constructor executed");

	}

	@Override
	public void method2() {

		System.out.println("Executing Derived class method2");

	}

	@Override
	public void method1() {
		super.method1();
		System.out.println("Executing derived clas method 1");
		super.method1();
	}

	@Override
	public void applyBreak() {
		System.out.println("Exxeccuting derived class method3");

	}

}

public class AbstractionDemo {

	public static void main(String[] args) {
		BaseInterface base = new Derived(1, 2, 3);
		base.applyBreak();
		System.out.println(BaseInterface.a);

		///Upcasting
		Object b = new Derived(1, 1, 1);
		
		
	}
}
