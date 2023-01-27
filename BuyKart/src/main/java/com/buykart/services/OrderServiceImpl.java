package com.buykart.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buykart.dto.DateDto;
import com.buykart.dto.OrdersDto;
import com.buykart.entities.Category;
import com.buykart.entities.Customer;
import com.buykart.entities.Orders;
import com.buykart.entities.Product;
import com.buykart.repositories.OrderRepository;
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@Override
	public void placeOrder(OrdersDto dto, Product product, Customer customer) {
		Orders orders=new Orders(dto, product, customer);
		orderRepository.save(orders);
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		return (List<Orders>) orderRepository.findAll();
	}

	@Override
	public List<Orders> getAllOrdersByDate(Date date) {
		
		return orderRepository.findByOrderDate(date);
		
		
	}
	@Transactional
	@Override
	public List<Orders> getAllOrdersById(Integer productId) {
		return orderRepository.findByProductId(productId);
	}

	@Override
	public List<Orders> getAllOrdersByCategory(Category category) {
		if (category.getCategoryId()==null) {
			Category dbcategory=categoryServiceImpl.fetch(category.getCategoryName());
			return orderRepository.findByOrderCategory(dbcategory.getCategoryId());
		}
		else {
			return orderRepository.findByOrderCategory(category.getCategoryId());
		}
	}

	@Override
	public List<Orders> getAllOrdersByDateRange(DateDto dateDto) {
	
		return orderRepository.findByOrdersByDateRange(dateDto.getStartDate(), dateDto.getEndDate());
	}

}
