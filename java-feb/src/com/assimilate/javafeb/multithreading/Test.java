package com.assimilate.javafeb.multithreading;

class Customer {
	int balance = 100000;

	synchronized void withdraw(int amount) {
		System.out.println("going to withdraw...");

		if (this.balance < amount) {
			System.out.println("Less balance; waiting for deposit...");
			try {
				wait();
			} catch (Exception e) {
			}
		}
		this.balance -= amount;
		System.out.println("withdraw completed...");
	}

	synchronized void deposit(int amount) {
		System.out.println("going to deposit...");
		this.balance += amount;
		System.out.println("deposit completed... ");
		notify();
	}
}

class Test {
	public static void main(String args[]) {
		final Customer c = new Customer();
		new Thread() {
			public void run() {
				c.withdraw(15000);
			}
		}.start();
		new Thread() {
			public void run() {
				c.deposit(10000);
			}
		}.start();

	}
}