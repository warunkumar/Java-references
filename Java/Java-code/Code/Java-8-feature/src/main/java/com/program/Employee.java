package com.program;

public class Employee {
	int id;
	String name;
	long phone;
	double salary;
	
	public Employee() {
		super();
	}
	
	public Employee(int id, String name, long phone, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", phone=" + phone + ", salary=" + salary + "]";
	}

	/*
	 * @Override public int compareTo(Employee o) {
	 * 
	 * //return this.name.compareTo(o.getName()); return this.id-o.getId(); }
	 */
	
	
	
	
}
