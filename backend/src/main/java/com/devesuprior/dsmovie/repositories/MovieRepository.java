package com.devesuprior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuprior.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
