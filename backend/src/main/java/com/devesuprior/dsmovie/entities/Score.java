package com.devesuprior.dsmovie.entities;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "tb_score")
public class Score {
// Classe de referencia Movie e User 
	// JPA só permite 1 atributo chave primeira, então crio uma classe auxiliar para chave primaria composta
	//private Movie movie;
	//private User user;
	// Score vaia pontar para um movie e user
	
	@EmbeddedId
	private ScorePK id = new ScorePK();
	
	private Double value;
	
	public Score() {
		
	}

	// set user
	public void setUser (User user) {
		id.setUser(user);
	}
	// set movie 
	public void setMovie(Movie movie) {
		id.setMovie(movie);
	}
	
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
