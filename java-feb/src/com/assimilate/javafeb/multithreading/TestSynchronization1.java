package com.assimilate.javafeb.multithreading;

class Table {
	private static Integer lock = 1;
	synchronized void printTable(int n) {// method not synchronized
		for (int i = 1; i <= 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(400);
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

	public void printTable(int n, int range) {

		synchronized (Table.class) {
			for (int i = 0; i < range; i++) {
				System.out.println(n * i);
				try {
					wait(1000);
//					Thread.sleep(1000);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}

		System.out.println("Write this table into file.");
		try {
			Thread.sleep(10000);
			System.out.println("Table is written to file");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Thread1 extends Thread {
	Table tableObj;

	Thread1(Table t) {
		this.tableObj = t;
	}

	public void run() {
//		tableObj.printTable(5);
		tableObj.printTable(5, 10);
	}

}

class Thread2 extends Thread {
	Table tableObj;

	Thread2(Table t) {
		this.tableObj = t;
	}

	public void run() {
//		tableObj.printTable(100);
		tableObj.printTable(100, 5);
	}
}

public class TestSynchronization1 {
	public static void main(String args[]) {
		Table obj = new Table();// only one object

//		Table obj2 = new Table();

		Thread1 t1 = new Thread1(obj);

		Thread2 t2 = new Thread2(obj);

		t1.start();
		t2.start();
	}
}