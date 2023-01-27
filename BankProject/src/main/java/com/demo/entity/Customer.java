package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cid;
	private String name;
	private String password;
	private String email;
	private Long contact;
	private String address;
	private Long accountnumber;
	private Double balance;
//	//this annotion needs insertable and updatable to false for passing the default value to the field
//	@Column(name = "role", columnDefinition = "varchar(255) DEFAULT 'Customer'" ,insertable = false,updatable = false)
	private String role;
}
