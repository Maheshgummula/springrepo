package com.buykart.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.buykart.dto.CustomerDto;
import com.buykart.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName;
	private Long customerContact;
	private String customerAddress;
	private String customerEmailId;
	private String customerPassword;

	@Enumerated(EnumType.STRING)
	private Role role;
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<Orders> order;

	public Customer(CustomerDto dto) {
		super();
		this.customerName = dto.getName();
		this.customerContact = dto.getContact();
		this.customerAddress = dto.getAddress();
		this.customerEmailId = dto.getEmailId();
		this.customerPassword = dto.getPassword();
	}

}
