package com.buykart.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buykart.entities.Category;
import com.buykart.entities.Product;
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {
	@Modifying
	@Query(value = "SELECT * FROM product ORDER BY product_name",nativeQuery = true)
	public List<Product> getAllProductsByName();
	

	public Product findByProductName(String productName);
	
	@Modifying
	@Query(value = "delete from product where category_id=?1",nativeQuery = true)
	public void deleteAllProductsByCategoryId(Integer id);
	
	@Modifying
	@Query(value = "SELECT * FROM product where product_name like ?1% ",nativeQuery = true)
	public List<Product> searchCategory(String productName);
}
