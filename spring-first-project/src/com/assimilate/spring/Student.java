package com.assimilate.spring;

public class Student {
	
	private String name;
	private String rollNo;
	
	private Course course;
	

	public Student() {
		System.out.println("Student constructor called..");
	}
	
	
	public Student(Course course) {
		System.out.println("Student constructor called..");
		this.course = course;
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



	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", course=" + course + "]";
	}



}
