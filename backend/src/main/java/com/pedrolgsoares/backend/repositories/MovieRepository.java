package com.pedrolgsoares.backend.repositories;

import com.pedrolgsoares.backend.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
