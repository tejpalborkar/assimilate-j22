package com.assimilate.javafeb.basic;

public class HelloWorld {
	
	// instance variable
	int x = 1000;
	
	static int y = 1000;
	public void method1() {
		x= 100;
		System.out.println(x);
		//local variables
		int b = 100;
	}

	
	public void method2() {
		x= 100;
	
	}
	public static void main(String args[]) {
//		HelloWorld helloWorld = new HelloWorld();
//		
//		System.out.println("x = "+helloWorld.x);
//		helloWorld.x = 10;
//		System.out.println("x = "+helloWorld.x);
		
		System.out.println("class variables y: "+y);

		System.out.println("Welcome to assimilate.....");
		System.out.println("Welcome to India.....");
		System.out.println("Welcome to Pune.....");
		
		System.out.println("Welcome ....." +args[0]);
		System.out.println("2nd argu ....." +args[1]);
		
		byte b = 127;
		System.out.println("byte: "+b);
		
		int i = 231;
		System.out.println("I =: "+i);
		
		boolean flag = true;
		 // 1 
		System.out.println("flag: "+flag);
		
		float f = 1002.234f;
		
		System.out.println("float variable : "+f);
		
		long l = 1243543333324l;
		System.out.println("Long variable : "+l);
		
		double d = 123456754323456.24234d;
		
		System.out.println("double : "+d);
		
		char c = 'c';
		System.out.println("Char : "+c);
	}
}
