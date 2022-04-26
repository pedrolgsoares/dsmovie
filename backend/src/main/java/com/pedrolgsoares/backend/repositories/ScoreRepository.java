package com.pedrolgsoares.backend.repositories;

import com.pedrolgsoares.backend.entities.Score;
import com.pedrolgsoares.backend.entities.ScorePK;
import com.pedrolgsoares.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
}
