package com.assimilate.springboot.javafeb.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "First name cannot be empty")
	@NotNull(message = "First name cannot be null")

	@Column(name = "firstName")
	private String firstName;

	@NotNull(message = "Last name cannot be null")
	@NotEmpty(message = "Last name cannot be empty")

	@Column(name = "lastName")
	private String lastName;

	@NotNull(message = "Roll no cannot be null")
	@Column(name = "rollNo")
	private Integer rollNo;

	@Size(min = 10, max = 13, message = "Mobile no must be between 10 and 13")
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "course")
	private String course;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getRollNo() {
		return rollNo;
	}

	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", rollNo=" + rollNo
				+ ", mobile=" + mobile + ", course=" + course + "]";
	}

}
