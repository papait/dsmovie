package com.devesuprior.dsmovie.services;
import java.util.List;
import com.devesuprior.dsmovie.dto.MovieDTO;
import com.devesuprior.dsmovie.entities.Movie;
import com.devesuprior.dsmovie.repositories.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// Anotaion registrar o movieservice como componente do sistema pq a classe e costumisada
@Service
public class MovieService {

	//Composição component
	
	@Autowired
	// Autowired o framework o spring ja tem o gerenciador de dependenciaia
	//private MovieRepository repository = new MovieRepository():
	private MovieRepository repository;
	//
	@Transactional (readOnly = true)
	public Page<MovieDTO> findAll (Pageable pageable){
		// Varios metodos já no REPOSITORy
		// List do tipo Movie ta na camada do JPA BD
		// Pegeable faz metodo funcionar paginado List agora e Page
		Page<Movie> result = repository.findAll(pageable);
		//Converter page Movie para page MovieDTO
		//Map função de alta ordem, aplica um metodo a cada elemento da lista 
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		
		return page;
	}
	
	public MovieDTO findById (Long id){
		//coloco o get() pegar o objeto Movie
		Movie result = repository.findById(id).get();
		MovieDTO dto = new MovieDTO(result);
		
		return dto;
	}
}
