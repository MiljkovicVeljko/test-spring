package com.kinoteka.kinoteka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kinoteka.kinoteka.model.Movie;
import com.kinoteka.kinoteka.service.MovieService;

@RestController
@lombok.RequiredArgsConstructor
@RequestMapping("/api/movies")
public class MovieController {
	
	private final MovieService movieService;
	
	@PostMapping
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		Movie createdMovie = this.movieService.createMovie(movie);
		if(createdMovie == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok(createdMovie);
	}
}
