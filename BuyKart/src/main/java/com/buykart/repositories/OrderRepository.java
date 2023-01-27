package com.buykart.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.buykart.entities.Orders;
@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer>{
	@Modifying
	@Query(value = "select * from orders where product_id=?1",nativeQuery = true)
	public List<Orders> findByProductId(Integer productId);
	
	public List<Orders> findByOrderDate(Date orderDate);
	
	
	@Query(value = "select * from orders where product_category=?1",nativeQuery = true)
	public List<Orders> findByOrderCategory(Integer categoryId);
	
	@Query(value = "select * from orders where order_date between ?1 and ?2",nativeQuery = true)
	public List<Orders> findByOrdersByDateRange(Date startDate,Date endDate);
	
	
	

}
