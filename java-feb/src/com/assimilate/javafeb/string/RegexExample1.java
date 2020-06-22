package com.assimilate.javafeb.string;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample1 {
	public static void main(String args[]) {
//1st way  
		Pattern p = Pattern.compile(".s");// . represents single character
		Matcher m = p.matcher("asa");
		boolean b = m.matches();
		
		System.out.println(b);

//2nd way  
		boolean b2 = Pattern.compile(".s").matcher("as").matches();

//3rd way  
		boolean b3 = Pattern.matches(".s", "as");

		System.out.println(b + " " + b2 + " " + b3);
		
		
		String input = "Z";
		
		System.out.println(Pattern.matches("[^abc]", input));
		
		
		System.out.println(Pattern.matches("[a-z]", input));
		
		String pattern = "[a-zA-Z0-9]{6}";
		
		System.out.println(Pattern.matches(pattern, "abC999"));
		
		
		boolean result =Pattern.matches("[789]{1}[0-9]{9}", "8953038944");
		
		
		if(result) {
			System.out.println("Valid mobile no");
		}else {
			System.out.println("Invalid mobile no");
		}
		
		System.out.println();//true  
		
		
		 Scanner sc=new Scanner(System.in);  
		 
		 System.out.println("Enter your input");
		 String in =sc.nextLine();
		 System.out.println("you have entered: "+in);
		
		
	}
}