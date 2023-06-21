package com.kinoteka.kinoteka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = true)
	private int rate;

	@Column(nullable = true)
	private String description;

	@Column(nullable = false)
	private String title;
	
	 @ManyToOne
	 private User director;
	
	public Movie(Movie movie) {
		this.rate = movie.getRate();
		this.description = movie.getDescription();
		this.title = movie.getTitle();
		this.director = movie.getDirector();
	}
}
