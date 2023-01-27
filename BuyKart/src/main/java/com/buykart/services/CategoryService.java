package com.buykart.services;

import java.util.List;
import java.util.Optional;

import com.buykart.entities.Category;

public interface CategoryService {
public String saveCategories(Category category);
public String updateCategories(Category category);
public String deleteCategories(Category category);
public Optional<Category> fetch(Integer categoryId);
public Category fetch(String categoryName);
public List<Category> getAllCategories();
public List<Category> getAllCategoriesByName();
public List<Category> searchCategoriesByName(Category categoryName);

}
