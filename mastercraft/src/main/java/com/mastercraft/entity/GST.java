package com.mastercraft.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class GST {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gstId;
	
	@Column(nullable = false, unique = true)
	private String gstNumber;

	@OneToOne
	private User customer;
}
