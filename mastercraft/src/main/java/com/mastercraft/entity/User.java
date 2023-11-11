package com.mastercraft.entity;

import java.util.List;

import com.mastercraft.util.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true)
	private long phoneNumber;

	private UserRole role; // ADMIN / MERCHANT / CUSTOMER

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gst_id")
	private GST gst;
	
	@OneToMany
	private List<Address> address; // Customer
	
	@OneToMany(mappedBy = "merchant")
	private List<Product> products; // Merchant
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orders; // Customer
	
	@OneToOne
	private Cart cart;

}