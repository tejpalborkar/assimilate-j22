package com.assimilate.javafeb.basic;

public class LoopDemo {

	public static void main(String[] args) {

		// Print numbers from 1 to 100

		int i = 1;

//		do {
//			System.out.println(i);
//			i++;
//		}while(i <=100);
//		
		int arr[] = { 1, 2, 3, 4 };
		int j = 1;
		while (j < arr.length) {
			System.out.println("running...");
			if (j >= 50) {
				// continue;
			}
			System.out.println(arr[j]);
			j++;
		}
		System.out.println("Program terminated");

		int month = 3;

		switch (month) {
		case 1:
			System.out.println("1- January");
			break;

		case 2:
			System.out.println("2- February");
			break;

		case 3: {
			System.out.println("3- March");
			System.out.println("3- March");
			System.out.println("3- March");
			System.out.println("3- March");
			break;

		}

		case 4:
			System.out.println("4- April");
			break;

		case 5:
			System.out.println("5- May");
			break;

		case 6:
			System.out.println("6- February");
			break;

		case 7:
			System.out.println("7- February");
			break;

		case 8:
			System.out.println("8- February");
			break;
		default:
			break;
		}

	}


}
