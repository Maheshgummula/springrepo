package com.buykart.dto;

import java.sql.*;
import java.time.LocalDate;

import com.buykart.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersDto {
	private Integer orderId;
	private Date orderDate;
	private Integer producstId;
	private Integer customersId;
	private Category orderCategory;

}
