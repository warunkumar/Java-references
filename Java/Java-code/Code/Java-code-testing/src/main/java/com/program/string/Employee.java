package com.program.string;

public class Employee {
	int id;
	String name;
	String emailId;
	
	public Employee(int id, String name, String emailId) {
		super();
		this.id = id;
		this.name = name;
		this.emailId = emailId;
	}

	public Employee() {}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
}
