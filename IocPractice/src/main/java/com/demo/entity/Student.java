package com.demo.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	Integer id;
	String name;
	Address address;
	List<Long> contacts;
	Set<Integer> numbers;
	Map<String,Integer> kv;
	public Student() {
	}
	public Student(Integer id, String name, Address address, List<Long> contacts, Set<Integer> numbers,
			Map<String, Integer> kv) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;
		this.numbers = numbers;
		this.kv = kv;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Long> getContacts() {
		return contacts;
	}
	public void setContacts(List<Long> contacts) {
		this.contacts = contacts;
	}
	public Set<Integer> getNumbers() {
		return numbers;
	}
	public void setNumbers(Set<Integer> numbers) {
		this.numbers = numbers;
	}
	public Map<String, Integer> getKv() {
		return kv;
	}
	public void setKv(Map<String, Integer> kv) {
		this.kv = kv;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", contacts=" + contacts + ", numbers="
				+ numbers + ", kv=" + kv + "]";
	}

	
	

}
