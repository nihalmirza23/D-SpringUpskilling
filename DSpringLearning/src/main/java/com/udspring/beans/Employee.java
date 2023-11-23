package com.udspring.beans;

public class Employee {

	
	
	private int id;
	private String firstName;
	private String LastName;
	private String location;
	private String position;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String firstName, String lastName, String location, String position) {
		super();
		this.id = id;
		this.firstName = firstName;
		LastName = lastName;
		this.location = location;
		this.position = position;
	}
	
	
	
}
