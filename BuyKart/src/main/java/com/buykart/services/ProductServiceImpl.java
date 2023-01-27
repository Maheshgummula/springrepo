package com.buykart.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buykart.dto.ProductDto;
import com.buykart.entities.Category;
import com.buykart.entities.Product;
import com.buykart.repositories.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductRepository repository;
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@Override
	public void addProduct(ProductDto dto, Category category) {
	Product product=new Product(dto,category);
	repository.save(product);
	}

	@Override
	public void deleteProduct(Product product) {
	repository.deleteById(product.getProductId());
		
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) repository.findAll();
	}

	@Override
	public Product updateProducts(Integer productId,ProductDto dto, Category category) {
		Product product=new Product(dto, category);
		product.setProductId(productId);
		repository.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProductsByName() {
		return repository.getAllProductsByName();
	}

	@Override
	public void deleteAllProducts(Category category) {
		// TODO Auto-generated method stub
		if (category.getCategoryId()!=null) {
			repository.deleteAllProductsByCategoryId(category.getCategoryId());
		}else {
			Category dbcategory=categoryServiceImpl.fetch(category.getCategoryName());
			repository.deleteAllProductsByCategoryId(dbcategory.getCategoryId());
		}
		
	}

	@Override
	public List<Product> searchProductsByName(Product product) {
		// TODO Auto-generated method stub
		return repository.searchCategory(product.getProductName());
	}

}
