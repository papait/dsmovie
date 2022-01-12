package com.devesuprior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuprior.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	// esse metedo é padrão sping JPA para encontrar email 
	User findByEmail(String email);
	
}
