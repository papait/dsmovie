package com.devesuprior.dsmovie.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
// Serializable uma interface no java esse  objeto desse tipo pode ser convertido para byte para implementar na rede
@Embeddable
public class ScorePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Chave estrangeira
	@ManyToOne
	@JoinColumn(name= "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public ScorePK () {
		
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
