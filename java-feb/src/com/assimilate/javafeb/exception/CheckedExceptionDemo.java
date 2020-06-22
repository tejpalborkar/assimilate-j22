package com.assimilate.javafeb.exception;

import java.io.File;
import java.io.IOException;

public class CheckedExceptionDemo {
	
	
	
	
	public static void main(String[] args) {

		int a = 10/0;
		
		File file = new File("test.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
		}

	}
}
