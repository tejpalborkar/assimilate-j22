package com.assimilate.javafeb.basic;

public class OperatorsDemo {
	
	public static void main(String[] args) {
		
		int a = 50;
		int b = 60;
		
		int result  = a + b;
		
		System.out.println(" a + b =: "+  result);
		
		int sub = b - a;
		System.out.println(" a - b =: "+  sub);
		
		System.out.println(" a * b =: "+  a *b);
		
		System.out.println(" a / b =: "+  a/b);
		
		System.out.println(" a % b =: "+  a%b);
		
		
		int i = 0;
		
		
		i++;
		
		i++;
		System.out.println("i="+i);
		
		i--;
		System.out.println("i="+i);
		
		++i;
		
		System.out.println("i="+i);
		
		--i;
		
		System.out.println("i="+i);
		
		
		i = 50;
		
		int j = 50;
		
		if(++i == j) {
			System.out.println(" i is equal to j");
		}else {
			System.out.println("i is not equal to j");
		}
		
		
		
		boolean res = i !=j;
		System.out.println("i != j: "+res);
		
		i = i+2;
		
		i-=100;
		
		 int k =i & 2; // 0000 0010    8421
		
		System.out.println("i : "+i);
		
		
		
	}

}
