package com.practice.entity;

import java.util.List;

public class Student {
private int id;
private String name;
private Address addresses;

public Student() {
	// TODO Auto-generated constructor stub
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

public Address getAddresses() {
	return addresses;
}

public void setAddresses(Address addresses) {
	this.addresses = addresses;
}

public Student(int id, String name, Address addresses) {
	super();
	this.id = id;
	this.name = name;
	this.addresses = addresses;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", addresses=" + addresses + "]";
}
public void showDetails() {
	System.out.println("Student [id=" + id + ", name=" + name+ "]");
	addresses.showAddresses();
	
}

}
