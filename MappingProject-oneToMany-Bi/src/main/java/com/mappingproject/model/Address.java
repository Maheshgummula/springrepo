package com.mappingproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String city;
private String state;

//@JsonManagedReference
//@OneToOne(mappedBy = "address",cascade = CascadeType.ALL)

@JsonManagedReference
@OneToOne(mappedBy = "address",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//to delete only child's entity data we need to change cascadeType 
//and we need break bi-directional relation by setting the  address of Student id to null
private Student student;
}
