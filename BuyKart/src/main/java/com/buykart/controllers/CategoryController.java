package com.buykart.controllers;

import java.util.List;

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

import com.buykart.entities.Category;
import com.buykart.exceptionhandler.CategoryException;
import com.buykart.services.CategoryServiceImpl;
import com.buykart.services.ProductServiceImpl;
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ProductServiceImpl impl;
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<Category>> getAllCategories(){
		 return new ResponseEntity<List<Category>>(categoryServiceImpl.getAllCategories(), HttpStatus.FOUND);
	}
	@GetMapping("/getAllCategoriesByName")
	public ResponseEntity<List<Category>> getAllCategoriesWithNames(){
//		return categoryServiceImpl.getAllCategoriesByName();
		return new ResponseEntity<List<Category>>(categoryServiceImpl.getAllCategoriesByName(), HttpStatus.FOUND);
	}
	@GetMapping("/searchCategoriesByName")
	public ResponseEntity<List<Category>> searchCategoriesByName(@RequestBody Category category){
		return new ResponseEntity<List<Category>>(categoryServiceImpl.searchCategoriesByName(category), HttpStatus.FOUND);
	}
	
	@PostMapping("/admin/saveCategory")
	public ResponseEntity<String> saveCategory(@RequestBody Category category) {
		if (category.getCategoryName()==null) {
			throw new CategoryException("Please Fill All Details of Category");
		}else {
			categoryServiceImpl.saveCategories(category);
			return new ResponseEntity<String>("Category Created", HttpStatus.CREATED);
		}
		
		
	}
	
	@PutMapping("/admin/updateCategory")
	public ResponseEntity<String> updateCategory(@RequestBody Category category) {
		if ((category.getCategoryId()==null)|| (category.getCategoryName()==null)) {
			throw new CategoryException("Please Fill All Details of Category");
		}else {
			String msg=categoryServiceImpl.updateCategories(category);
			return new ResponseEntity<String>(msg, HttpStatus.OK); 
		}
		
		
	}
	@DeleteMapping("/admin/deleteCategory")
	public ResponseEntity<String> deleteCategory(@RequestBody Category category) {
		impl.deleteAllProducts(category);
		categoryServiceImpl.deleteCategories(category);
		return new ResponseEntity<String>("Category Deleted", HttpStatus.OK);
	}
	
	

}
