package com.buykart.services;

import java.util.List;

import com.buykart.dto.ProductDto;
import com.buykart.entities.Category;
import com.buykart.entities.Product;

public interface ProductService {
	public void addProduct(ProductDto dto,Category category);
	public void deleteProduct(Product product);
	public List<Product> getAllProducts();
	Product updateProducts(Integer productId, ProductDto dto, Category category);
	public List<Product> getAllProductsByName();
	public	void deleteAllProducts(Category category);
	public List<Product> searchProductsByName(Product product);

}
