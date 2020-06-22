package com.assimilate.javafeb.multithreading;

import java.awt.Checkbox;

class MyThread1 extends Thread {

	@Override
	public void run() {
		System.out.println(this.getName() + " in ruuning state..");
//		try {
//			System.out.println(this.getName() + " is waiting..");
////			Thread.sleep(5);
//			System.out.println(this.getName() + " is runnable..");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		System.out.println(this.getName() + " is running..");
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " ->  " + i);
		}
		System.out.println(this.getName() + "---> Mythread terminated..");

	}
}

class MyThread2 extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " ->  " + i);
		}
		System.out.println(this.getName() + "---> Mythread completed..");

	}
}

class MyThread3 extends Checkbox implements Runnable {

	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.getName() + " ->  " + i);
		}
		System.out.println(this.getName() + "---> Mythread completed..");
	}

	@Override
	protected void finalize() throws Throwable {

	}

}

public class MultiThreadingDemo {

	public static void main(String[] args) throws InterruptedException {
		MyThread1 t1 = new MyThread1();
		t1.setName("Thread-1");

		t1.setPriority(Thread.MAX_PRIORITY);

//		MyThread1 t2 = new MyThread1();
//		t2.setName("Thread-2");
//
//		MyThread1 t3 = new MyThread1();
//		t3.setName("Thread-3");

		MyThread2 t4 = new MyThread2();
		t4.setName("Thread-4");
		t4.setPriority(Thread.MIN_PRIORITY);

		MyThread3 t5 = new MyThread3();
		t5.setName("Thread-5");
		Thread t5t = new Thread(t5);

		t5t.setPriority(Thread.NORM_PRIORITY);
		t5t.setDaemon(true);
		t1.start();
//		t2.start();
//		t3.start();
		t4.start();
		t5t.start();
//		t1.join();
//		t4.join();
//		t5t.join();

		for (int i = 0; i < 10; i++) {
			System.out.println("Main-i -> " + i);
		}
		System.out.println("Main executed...");

	}
}
