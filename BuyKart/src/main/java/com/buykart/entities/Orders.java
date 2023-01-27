package com.buykart.entities;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.buykart.dto.OrdersDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
//	@JsonFormat(shape =JsonFormat.Shape.STRING,pattern ="yyyy-MM-dd")
//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	private LocalDate orderDate;
	private Date orderDate;
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "productId")
	 Product Product;
	@ManyToOne(targetEntity = Customer.class)
	@JoinColumn(name = "customersId")
	 Customer customer;
	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name = "productCategory")
	private Category orderCategory;
	public Orders(OrdersDto dto,Product product,Customer customer) {
		super();
		this.orderId = dto.getOrderId();
		this.orderDate = dto.getOrderDate();
		this.orderCategory=product.getCategory();
		Product = product;
		this.customer = customer;
	}
}

