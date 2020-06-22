package com.assimilate.javafeb.exception;

public class Calculator implements CalculatorInterface {

	public int add(int a, int b) {
		return a + b;

	}

	public int divide(int numerator, int denomenator) throws ArithmeticException {

		if (denomenator == 0) {
			// throw new Exception("Devide by zero is not allowed.. Please provide
			// denomenator non zero");
		//	throw new DivideByZeroException("Devide by zero is not allowed.. Please provide denomenator non zero");
			throw new ArithmeticException();
		}

		return numerator / denomenator;

	}

	@Override
	public int subtract(int a, int b) {
		// TODO Auto-generated method stub
		return a - b;
	}

	@Override
	public int multiply(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

}
