package com.reflection;

public class Employee {
	public int id=12;
	private String name="warun";
	protected long phone=1234567890;
	
	public Employee() {
		
	}
	
	private Employee(long phone) {
		this.phone=phone;
	}

	public Employee(int id, String name, long phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	

	protected String getName() {
		return name;
	}

	

	private long getPhone() {
		return phone;
	}

	
	
	
	
	
	
	
	
	
}
