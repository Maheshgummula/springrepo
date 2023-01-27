package com.buykart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.buykart.entities.Category;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
@Modifying
@Query(value = "delete from category where category_name=?1",nativeQuery = true)
public void deleteByCategoryName(String categoryName);

@Modifying
@Query(value = "SELECT * FROM category ORDER BY category_name",nativeQuery = true)
public List<Category> getCategoryByName();

public Category findByCategoryName(String categoryName);

@Modifying
@Query(value = "SELECT * FROM category where category_name like ?1% ",nativeQuery = true)
public List<Category> searchCategory(String categoryName);
}
