package com.assimilate.javafeb.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputSteamDemo {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("test.txt", false);
			String s = "Wsdfd";
//			fos.write(s.getBytes());
			fos.write(123);
			fos.flush();
			fos.close();
			System.out.println("File  written success.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}
