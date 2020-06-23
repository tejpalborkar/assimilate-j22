package com.assimilate.javafeb.reflection;

public class Company {
	
	private String name = " Assimilate tech";
	public String owner = " Sanjay";
	protected Integer revenue;
	
	public Company(String name, String owner, Integer revenue) {
		super();
		this.name = name;
		this.owner = owner;
		this.revenue = revenue;
	}

	public Company(String name, Integer revenue) {
		super();
		this.name = name;
		this.revenue = revenue;
	}

	public Company(String name, String owner) {
		super();
		this.name = name;
		this.owner = owner;
	}
	
	
	public Company() {
	}

	public void printCompanyName() {
		System.out.println("Executing printCompanyName");
		System.out.println("company name: "+name);
	}

	private void printOwnerName() {
		System.out.println("Executing printOwnerName");
		System.out.println(owner);
	}
	
	

}
