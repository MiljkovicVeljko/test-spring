package com.kinoteka.kinoteka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kinoteka.kinoteka.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
  
}
