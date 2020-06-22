package com.assimilate.javafeb.string;

public class StringDemo {

	public static void main(String[] args) {

		String s1 = "Welcome to India";

		System.out.println(s1);

		System.out.println(s1.charAt(4));

		s1 = s1.concat(" Welcome to assimilate");
		System.out.println(s1);
		System.out.println(s1);
		s1 = "Welcome:to:India:Welcome:to:assimilate";
		
		String words [] =s1.split(":");
		System.out.println(words.length);
		
		for (int i = 0; i < words.length; i++) {
			System.out.println(words[i]);
		}
		
		System.out.println(s1.endsWith("sdsf"));
		System.out.println(s1.startsWith("Wel"));
		
		
		String s3 = "aaa";
		String s2 = "Abc";
		
		/// Abc, Bcd
		
		
		String dictionary [] = {"John", "johny", "Sam", "Kit"};
		
		
		System.out.println(s2.equals(s3));
		
		
		System.out.println(s3.compareTo(s2));
		
		String s4 = "Welcome to assimilate";
		
		System.out.println(s4.substring(2));
		System.out.println(s4.substring(5));
		
		
		System.out.println(s4.substring(3, 6));
		System.out.println(s4.substring(7, 8));
		s4 = "                         ";
		System.out.println(s4.isEmpty());
		
		s4="  aaab caa  ";
		System.out.println(s4.length());
		System.out.println(s4.trim().length());
		System.out.println("----------------------------------------");
		
		
		String s5 = "abc";
		String s6 = "abc";
		String s7 ="xyz";
		
		
		System.out.println(s5.equals(s6)); //true
		System.out.println(s6.equals(s7)); //false
		
		System.out.println("" +(s5 == s6)); //true
		System.out.println("" +(s6 == s7)); //false
		
		
		String s8 = new String ("abc");
		String s9 = new String ("abc");
		String s10 = new String ("xyz");
		System.out.println("====================");
		System.out.println(s8.equals(s9)); // true
		System.out.println(s9.equals(s10)); // false
		
		System.out.println(s9.equals(s5)); // true
		System.out.println(s9.equals(s6)); // true
		System.out.println(s9.equals(s7)); // false
		System.out.println("---------------------------------");
		
		System.out.println("" +(s8 == s9)); //false
		System.out.println("" +(s9 == s10)); //false
		
		System.out.println("" +(s9 == s5)); //false
		System.out.println("" +(s9 == s6)); //false
		
		
		char arr[] = s8.toCharArray();
		System.out.println(arr);
		
		//write a program to reverse the string
		//write a program to count the no of words
		// program to print given string in dictionary form/lexicographically
		//
	}
}
