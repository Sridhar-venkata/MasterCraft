package com.mastercraft.entity;

import java.util.List;

import com.mastercraft.util.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	private String password;

	@Column(nullable = false, unique = true)
	private long phone;

	private UserRole role; // ADMIN / MERCHANT / CUSTOMER

	private Address address; // Customer
	
	private List<Product> products; // Merchant
	
	private List<Order> orders; // Customer

}