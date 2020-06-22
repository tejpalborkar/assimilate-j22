package com.assimilate.javafeb.basic;

public class ArrayDemo {
	
	public static void main(String[] args) {
		
		int arr[] = new int [3];
		
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		System.out.println("element at arr[0] : "+arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		float [] floatArr = new float [50];
		
		
		int arr2[] = {1, 2,3,4}; 
		
			
		System.out.println("Size of arr: "+arr2.length);
		
		
		/// Loop
		/*
		 * for (int i = 0; i < arr2.length; i++) {
		 * 
		 * arr[i] }
		 */
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(" i: "+i);
		}
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println("arr[]"+ arr2[i]);
		}
			
		System.out.println("Out of loop");
		
	}

}
