package com.kinoteka.kinoteka.model;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(nullable = true)
	private String description;

	@OneToOne
	private Address address;

	// @OneToMany(mappedBy = "director")
	// private List<Movie> directedMovies;

	@ManyToMany
	@JoinTable(name = "favorites", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private List<Movie> favoriteMovies;
}
