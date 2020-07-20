package com.assimilate.spring;

public class Student {
	
	private String name;
	private String rollNo;
	
	
	private Student() {
		
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getRollNo() {
		return rollNo;
	}



	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
	
	
	

}
