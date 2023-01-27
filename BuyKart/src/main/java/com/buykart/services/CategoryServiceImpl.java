package com.buykart.services;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buykart.entities.Category;
import com.buykart.repositories.CategoryRepository;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repository;

	@Override
	public String saveCategories(Category category) {
		repository.save(category);
		return "Data Inserted Successfully";
	}

	@Override
	public String updateCategories(Category category) {
		Optional<Category> dbcategory = repository.findById(category.getCategoryId());
		if (dbcategory.isPresent()) {
			dbcategory.get().setCategoryName(category.getCategoryName());
			repository.save(dbcategory.get());
			return "Category Updated Successfully";
		} else {
			return "Something went wrong";
		}
	}

	@Override
	public String deleteCategories(Category category) {
		if (category.getCategoryId()==null) {
			repository.deleteByCategoryName(category.getCategoryName());
		}else {
         repository.deleteById(category.getCategoryId());
         }
		return "Deleted Successfully";
	}

	@Override
	public Optional<Category> fetch(Integer categoryId) {
		return repository.findById(categoryId);
		
	}

	@Override
	public Category fetch(String categoryName) {
		
		return repository.findByCategoryName(categoryName);
	}

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) repository.findAll();
	}
	@Override
	public List<Category> getAllCategoriesByName() {
		return  repository.getCategoryByName();
	}

	@Override
	public List<Category> searchCategoriesByName(Category category) {
	
		return repository.searchCategory(category.getCategoryName());
	}

}
