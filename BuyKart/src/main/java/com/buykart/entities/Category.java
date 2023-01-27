package com.buykart.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer categoryId;
	@Column(unique = true)
	private String categoryName;
//	@OneToMany(targetEntity = Product.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
//	private List<Product> products;
	
}
