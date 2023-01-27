package com.buykart.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buykart.dto.ProductDto;
import com.buykart.entities.Category;
import com.buykart.entities.Product;
import com.buykart.repositories.CategoryRepository;
import com.buykart.repositories.ProductRepository;
import com.buykart.services.ProductService;
import com.buykart.services.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductServiceImpl serviceImpl;
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProductsFromDB(){
		return new ResponseEntity<List<Product>>(serviceImpl.getAllProducts(), HttpStatus.FOUND);
	}
	@GetMapping("/getAllProductsforstream")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=serviceImpl.getAllProducts();
		System.out.println("Products     "+products);
		List<Product> list=products.stream().filter(product ->product.getCategory().getCategoryName().equals("FootWears")).filter(p->p.getProductPrice() > 1000).collect(Collectors.toList());
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Double>> getAllProduct(){
		List<Product> products=serviceImpl.getAllProducts();
		System.out.println("Products     "+products);
		List<Double> list=products.stream().filter(product ->product.getCategory().getCategoryName().equals("FootWears")).map(p->p.getProductPrice()* 0.9).collect(Collectors.toList());
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.FOUND);
	}
	
	
	@GetMapping("/getAllProductsByName")
	public ResponseEntity<List<Product>> getAllProductsByNameFromDB(){
	return	new ResponseEntity<List<Product>>(serviceImpl.getAllProductsByName(), HttpStatus.FOUND);
	}
	
	@GetMapping("/searchProductsByName")
	public ResponseEntity<List<Product>> searchProductsByName(@RequestBody Product product){
		return new ResponseEntity<List<Product>>(serviceImpl.searchProductsByName(product), HttpStatus.FOUND);
	}
	
@PostMapping("/admin/addProduct")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto){
		Optional<Category> optional=categoryRepository.findById(productDto.getCategoryId());
		if (!optional.isPresent()) {
			return new ResponseEntity<String>("category Invalid", HttpStatus.CONFLICT);
		}
		Category category=optional.get();
		serviceImpl.addProduct(productDto, category);
		return new ResponseEntity<String>("Added Successfully", HttpStatus.CREATED);
	}
@DeleteMapping("/admin/deleteProduct")
public ResponseEntity<String> deletingProducts(@RequestBody Product product){
	serviceImpl.deleteProduct(product);
	return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK); 
}
@PutMapping("/admin/updateProducts/{productId}")
public ResponseEntity<Product> updateProducts(@PathVariable Integer productId, @RequestBody @Valid ProductDto productDto){
	Optional<Category> optional=categoryRepository.findById(productDto.getCategoryId());
	Category category=optional.get();
	Product newproduct=serviceImpl.updateProducts(productId, productDto, category);
	return new ResponseEntity<Product>(newproduct, HttpStatus.OK); 
}
}
