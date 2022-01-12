package com.devesuprior.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesuprior.dsmovie.dto.MovieDTO;
import com.devesuprior.dsmovie.services.MovieService;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

	@Autowired
	private MovieService service;
	// Getmappin Matodo vai Responder pela requisão do HTTP pelo caminho /movie
	@GetMapping
	public Page<MovieDTO> findAll(Pageable pegeable){
		return service.findAll(pegeable);
		
	}
	
	@GetMapping(value="/{id}")
	// Anotaion PathVariable vai verificar se o argumento da URls /{ID} vai casar com o argumento do parametro iD
	public MovieDTO findById(@PathVariable Long id){
		return service.findById(id);
		
	}
}
