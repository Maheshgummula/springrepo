package com.buykart.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.buykart.dto.ProductDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String productName;
	private Double productPrice;
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	@OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL,orphanRemoval = true)
	
	private List<Orders> order;
	
	public Product(ProductDto dto, Category category) {
		this.productName = dto.getName();
		this.productPrice = dto.getPrice();
		this.category = category;
	}

}
