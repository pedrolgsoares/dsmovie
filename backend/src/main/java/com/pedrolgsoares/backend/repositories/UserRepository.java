package com.pedrolgsoares.backend.repositories;

import com.pedrolgsoares.backend.entities.Movie;
import com.pedrolgsoares.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
