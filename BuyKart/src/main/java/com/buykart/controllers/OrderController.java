package com.buykart.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buykart.dto.DateDto;
import com.buykart.dto.OrdersDto;
import com.buykart.entities.Category;
import com.buykart.entities.Customer;
import com.buykart.entities.Orders;
import com.buykart.entities.Product;
import com.buykart.repositories.CustomerRepository;
import com.buykart.repositories.ProductRepository;
import com.buykart.services.OrderServiceImpl;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderServiceImpl serviceImpl;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ProductRepository productRepository;

	@PostMapping("/customer/placeOrder")
	public ResponseEntity<String> PlaceOrders(@RequestBody OrdersDto dto) {
		Optional<Customer> dbcustomer = customerRepository.findById(dto.getCustomersId());
		Optional<Product> dbproduct = productRepository.findById(dto.getProducstId());

		Customer customer = dbcustomer.get();
		Product product = dbproduct.get();
		serviceImpl.placeOrder(dto, product, customer);
		return new ResponseEntity<String>("Order has been Placed", HttpStatus.CREATED);
	}

	@GetMapping("/admin/getAllProductsforstreamWithFootWears")
	public ResponseEntity<List<Orders>> getAllProductStreams(){
		List<Orders> list=serviceImpl.getAllOrders();
		List<Orders> newList=list.stream().filter(t ->t.getOrderCategory().getCategoryName().equalsIgnoreCase("footwears")).toList();
		System.out.println(newList);
		return new ResponseEntity<>(newList, HttpStatus.FOUND);
	}
	
	@GetMapping("/admin/getAllOrders")
	public ResponseEntity<List<Orders>> getAllOrders() {
		return new ResponseEntity<List<Orders>>(serviceImpl.getAllOrders(), HttpStatus.FOUND);
	}

	@GetMapping("/admin/getAllOrdersWithProductName")
	public ResponseEntity<List<Orders>> getAllOrderswithProductName(@RequestBody Product product) {
		Product dbproduct = productRepository.findByProductName(product.getProductName());
		return new ResponseEntity<List<Orders>>(serviceImpl.getAllOrdersById(dbproduct.getProductId()), HttpStatus.FOUND);
	}

	@GetMapping("/admin/getAllOrdersWithCategory")
	public ResponseEntity<List<Orders>> getAllOrderswithCategory(@RequestBody Category category) {
		return new ResponseEntity<List<Orders>>(serviceImpl.getAllOrdersByCategory(category), HttpStatus.FOUND);
	}
	@GetMapping("/admin/getAllOrdersByDateRange")
	public ResponseEntity<List<Orders>> getAllOrdersWithDateRange(@RequestBody DateDto dateDto) {
		return new ResponseEntity<List<Orders>>(serviceImpl.getAllOrdersByDateRange(dateDto), HttpStatus.FOUND);
	}

	@GetMapping("/admin/getAllOrdersByDate")
	public ResponseEntity<List<Orders>> getAllOrdersByDate(@RequestBody Orders order) {
		return new ResponseEntity<List<Orders>>(serviceImpl.getAllOrdersByDate(order.getOrderDate()), HttpStatus.FOUND);
	}
	

}
