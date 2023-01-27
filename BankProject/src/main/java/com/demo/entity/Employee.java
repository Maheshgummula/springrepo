package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String password;
	private String email;
//	//this annotion needs insertable and updatable to false for passing the default value to the field
//		@Column(name = "role", columnDefinition = "varchar(255) DEFAULT 'Employee'" ,insertable = false,updatable = false)
	private String role;

}
