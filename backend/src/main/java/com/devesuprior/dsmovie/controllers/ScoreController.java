package com.devesuprior.dsmovie.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesuprior.dsmovie.dto.MovieDTO;
import com.devesuprior.dsmovie.dto.ScoreDTO;
import com.devesuprior.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

	@Autowired
	private ScoreService  service;
	
	@PutMapping
	//@RequestBody Body da requisão foi pego do  put do postoman
	public MovieDTO saveScore(@RequestBody ScoreDTO dto){
		MovieDTO movieDTO = service.saveScore(dto);
		return movieDTO;
	}
}
