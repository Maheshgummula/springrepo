package com.buykart.services;

import java.sql.Date;
import java.util.List;

import com.buykart.dto.DateDto;
import com.buykart.dto.OrdersDto;
import com.buykart.entities.Category;
import com.buykart.entities.Customer;
import com.buykart.entities.Orders;
import com.buykart.entities.Product;

public interface OrderService {
	public void placeOrder(OrdersDto dto,Product product,Customer customer);
	public List<Orders> getAllOrders();
	public List<Orders> getAllOrdersByDate(Date date);
	public List<Orders> getAllOrdersById(Integer productId);
	public List<Orders> getAllOrdersByCategory(Category category);
	public List<Orders> getAllOrdersByDateRange(DateDto dateDto);
	

}
