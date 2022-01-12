package com.devesuprior.dsmovie.services;

import java.util.List;
import com.devesuprior.dsmovie.dto.MovieDTO;
import com.devesuprior.dsmovie.dto.ScoreDTO;
import com.devesuprior.dsmovie.entities.Movie;
import com.devesuprior.dsmovie.entities.Score;
import com.devesuprior.dsmovie.entities.User;
import com.devesuprior.dsmovie.repositories.MovieRepository;
import com.devesuprior.dsmovie.repositories.ScoreRepository;
import com.devesuprior.dsmovie.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Anotaion registrar o movieservice como componente do sistema pq a classe e costumisada
@Service
public class ScoreService {

	// Composição component

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	// Esse anotation vai me garantir a transsação com o banco
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum += s.getValue();
		}

		double avg = sum / (movie.getScores().size());

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);

	}

}
