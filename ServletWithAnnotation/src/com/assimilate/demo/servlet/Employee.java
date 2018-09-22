package com.assimilate.demo.servlet;

public class Employee {

	private String name;
	private Integer mobile;

	public Employee() {
	}

	public Employee(String name, Integer mobile) {
		super();
		this.name = name;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMobile() {
		return mobile;
	}

	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", mobile=" + mobile + "]";
	}

	
}
