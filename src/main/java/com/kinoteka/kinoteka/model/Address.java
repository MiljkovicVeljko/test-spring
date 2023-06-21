package com.kinoteka.kinoteka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private String number;
	
	@Column(nullable = true) 
	private int postalCode;
}
