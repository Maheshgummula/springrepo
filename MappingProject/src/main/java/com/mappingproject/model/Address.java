package com.mappingproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String city;
private String state;
}
