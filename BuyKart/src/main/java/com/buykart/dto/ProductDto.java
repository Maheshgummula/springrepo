package com.buykart.dto;

import org.springframework.lang.NonNull;

import com.buykart.entities.Product;

public class ProductDto {
	private @NonNull Integer id;
	private @NonNull String name;
	private @NonNull Double Price;
	private @NonNull Integer categoryId;
	public ProductDto() {
		// TODO Auto-generated constructor stub
	}
	
	 public ProductDto(Product product) {
	        this.setId(product.getProductId());
	        this.setName(product.getProductName());
	        this.setPrice(product.getProductPrice());
	        this.setCategoryId(product.getCategory().getCategoryId());
	    }

	public ProductDto(@NonNull Integer id,@NonNull String name,@NonNull Double price,@NonNull Integer categoryId) {
		super();
		this.id = id;
		this.name = name;
		Price = price;
		this.categoryId = categoryId;
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

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

}
