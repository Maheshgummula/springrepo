package com.streams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.streams.model.Orders;
@Repository 
public interface OrdersRepo  extends CrudRepository<Orders, Long>{

}
