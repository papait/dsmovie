package com.devesuprior.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesuprior.dsmovie.entities.Score;
import com.devesuprior.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
