package com.assimilate.javafeb.accessmodifires;

import com.assimilate.javafeb.accessmodifires.OuterInterface.InnerInterface;
import com.assimilate.javafeb.accessmodifires.TestNestedInterface.ClassInnerInterface;

class A {
	// outer class
	private String name = " John";

	private static String compName = "Assimilate";

	static class Inner {

		void msg() {
			System.out.println("data is " + compName);
		}
	}

}

class B {

	public void printMessage() {
		System.out.println("Executing printMessage..");

		final int a = 100;
		// Local Inner class
		class LocalInner {

			public void localInnerMethod() {
				System.out.println("Executing local inner method..");
			}
		}

		class TestMethodLocal extends LocalInner {

		}

		LocalInner localIn = new TestMethodLocal();
		localIn.localInnerMethod();
	}

}

interface Radio {

	void switchChannel();
}

class RadioImpl implements Radio {

	@Override
	public void switchChannel() {
		System.out.println("channel switching..");

	}

}

interface OuterInterface {

	int add();

	interface InnerInterface {

		int add();
	}

}

class TestNestedInterface implements InnerInterface, OuterInterface {

	@Override
	public int add() {
		return 0;
	}

	protected interface ClassInnerInterface {
		int subtract();
	}

}

class Third implements ClassInnerInterface {

	@Override
	public int subtract() {
		// TODO Auto-generated method stub
		return 0;
	}

}

public class InnerClassesDemo {

	public static void main(String[] args) {
		A a = new A();

//		A.Inner inner = a.new Inner();

		A.Inner inner = new A.Inner();

		inner.msg();

		B b = new B();
		b.printMessage();

		Radio radio = new RadioImpl();
		radio.switchChannel();

		Radio rado = new Radio() {
			@Override
			public void switchChannel() {
				System.out.println("executing rado..");

			}

		};
		rado.switchChannel();
	}
}
