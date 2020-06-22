package com.assimilate.javafeb.accessmodifires;

public class Employee {

	private int salary;

	String name;

	protected int id = 1000;

	public String mobile;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public static void main(String[] args) {
		Employee employee = new Employee();

		employee.salary = 1000;

		employee.name = "Tejpal";
		System.out.println(employee.getSalary());
	}

	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", name=" + name + ", id=" + id + ", mobile=" + mobile + "]";
	}

	/*
	 * @Override public int compareTo(Employee other) {
	 * 
	 * if (other.id == this.id) return 0;
	 * 
	 * if (this.id > other.id) return 1;
	 * 
	 * else return -1;
	 * 
	 * }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}


}
