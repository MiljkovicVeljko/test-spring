package com.kinoteka.kinoteka.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kinoteka.kinoteka.model.Movie;
import com.kinoteka.kinoteka.model.User;
import com.kinoteka.kinoteka.repositories.MovieRepository;
import com.kinoteka.kinoteka.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieService {
	
	private final MovieRepository movieRepository;
	private final UserRepository userRepository;
	
	public Movie createMovie(Movie movie) {
		Movie newMovie = new Movie(movie);
		if(movie.getDirector() == null) {
			return null;
		}
		Optional<User> optionalDirector = this.userRepository.findById(movie.getDirector().getId());
		if(optionalDirector.isPresent() == false) {
			return null;
		}
		
		User director = optionalDirector.get();
		newMovie.setDirector(director);
		
		return this.movieRepository.save(newMovie);
	}
}
