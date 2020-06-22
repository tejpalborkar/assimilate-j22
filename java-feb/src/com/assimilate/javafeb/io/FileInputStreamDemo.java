package com.assimilate.javafeb.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");

			int c = 0;
			while (c >= 0) {
				c = fis.read();
				System.out.print(c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
