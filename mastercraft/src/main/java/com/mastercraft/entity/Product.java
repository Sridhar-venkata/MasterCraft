package com.mastercraft.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@Column(nullable = false)
	private String name;
	private String description;
	@Column(nullable = false)
	private int quantity;
	@Column(precision = 2)
	private double price;
	
	private List<Review> review;
}
