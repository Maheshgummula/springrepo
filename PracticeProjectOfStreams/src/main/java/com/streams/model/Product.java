package com.streams.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private String name;
	  private String category;
	  @With
	  private Double price;
	  
	  @ManyToMany(mappedBy = "products")
	  @ToString.Exclude
	  Set<Orders> orders;

}
