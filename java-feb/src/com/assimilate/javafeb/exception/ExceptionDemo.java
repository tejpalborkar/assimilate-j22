package com.assimilate.javafeb.exception;

public class ExceptionDemo {

	public static void main(String[] args) {

		int a = 100;
		int b = 20;

		try {
			int result = a / b;
			System.out.println("a/b: " + result);

			String str = "abcd";
			System.out.println(str.charAt(2));

		} catch (ArithmeticException e) {
			System.out.println("Caugtht the exception");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Exception occured: " + e.getMessage());
		} finally {
			// free the resources.
			// always executes.
			System.out.println("Executing finally..");
		}

		System.out.println("Welcome to assimilate");

	}

}
