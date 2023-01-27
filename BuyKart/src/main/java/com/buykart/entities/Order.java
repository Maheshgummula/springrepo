package com.buykart.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;
	private Date date;
	@ManyToMany(mappedBy = "listOrder",fetch = FetchType.LAZY)
	private List<Product> Prduct;

}
