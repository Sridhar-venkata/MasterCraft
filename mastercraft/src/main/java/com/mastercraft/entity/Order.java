package com.mastercraft.entity;


import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@Column(nullable = false)
	private LocalDateTime expDeliveryDate;
	
	@Column(precision = 2)
	private double totalPrice;
	
	@OneToMany
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User customer;
}