package com.streams.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_order")
public class Orders {
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private LocalDate orderDate;
	  private LocalDate deliveryDate;
	  private String status;
	  @ManyToOne
	  private Customer customer;
	  
	  @ManyToMany
	  @JoinTable(
			  name = "order_product_relationship",
			  joinColumns= {@JoinColumn(name = "order_id")},
			  inverseJoinColumns = {@JoinColumn(name="product_id")}
			  )
	  @ToString.Exclude
	  Set<Product> products;
}
