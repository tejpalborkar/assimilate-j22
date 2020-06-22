package com.assimilate.javafeb.io;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	public static void main(String[] args) {
		File file = new File("/home/tejpal/testfolder/test.txt");

		try {
			boolean fileCreated = file.createNewFile();
//			System.out.println("File created : " + fileCreated);
//
//			if (file.exists()) {
//				System.out.println("file already exist..");
//			}
//			boolean deleted = file.delete();
//			System.out.println("File deleted: "+deleted);

			System.out.println("Is Directory: " + file.isDirectory());
			System.out.println("Is File: " + file.isFile());

			System.out.println("file location: " + file.getAbsolutePath());
			System.out.println("file location: " + file.getCanonicalPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
