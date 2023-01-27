package com.buykart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private String name;
	private String emailId;
	private String password;
	private Long contact;
	private String address;
	

}
