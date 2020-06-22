package com.assimilate.javafeb.exception;

class TestCustomException1 {

	static void validate(int age) throws InvalidAgeException {
		if (age < 18)
			throw new InvalidAgeException("age not valid");
		else
			System.out.println("welcome to vote");
	}

	public static void main(String args[]) {
		try {
			validate(19);
		} catch (Exception m) {
			System.out.println("Exception occured: " + m);
		}

		System.out.println("rest of the code...");
	}
}