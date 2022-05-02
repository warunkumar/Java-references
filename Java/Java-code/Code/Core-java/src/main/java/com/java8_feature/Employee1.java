package com.java8_feature;

public class Employee1 {
	int id;

	public Employee1() {
		super();
	}

	public Employee1(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee1{" +
				"id=" + id +
				'}';
	}
}
