package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	private String sname;
	private String address;
	private Long contact;
	private Double fees;
	public Student() {
	}
	public Student(Integer sid, String sname, String address, Long contact, Double fees) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.contact = contact;
		this.fees = fees;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public Double getFees() {
		return fees;
	}
	public void setFees(Double fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", contact=" + contact + ", fees="
				+ fees + "]";
	}

}
