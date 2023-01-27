package com.demo.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "users_info")
public class User {
	@Id
	@GeneratedValue
	@Column(name ="user_id")
	private Long id;
	@Column(name ="user_name")
	private String name;
	@Column(name ="user_pwd")
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "roles",joinColumns = @JoinColumn(name="user_id"))
	@Column(name = "user_role")
	private List<String> roles;

}
