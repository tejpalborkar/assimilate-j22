package com.assimilate.javafeb.exception;

public class UserTest {
	public static void main(String[] args) {

		CalculatorInterface calculator = new Calculator();

		int result;
		try {
			result = calculator.add(10, 20);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		result = calculator.divide(100, 0);
		/*
		 * try { } catch (DivideByZeroException e) { e.printStackTrace(); }
		 */
		System.out.println("divide: " + result);

	}
}
