package com.pedrolgsoares.backend.services;

import com.pedrolgsoares.backend.dto.MovieDTO;
import com.pedrolgsoares.backend.dto.ScoreDTO;
import com.pedrolgsoares.backend.entities.Movie;
import com.pedrolgsoares.backend.entities.Score;
import com.pedrolgsoares.backend.entities.User;
import com.pedrolgsoares.backend.repositories.MovieRepository;
import com.pedrolgsoares.backend.repositories.ScoreRepository;
import com.pedrolgsoares.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO){

        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        //Preparar na memória os 3 dados recebido no score
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDTO.getScore());

        // Realizar o save
        score = scoreRepository.saveAndFlush(score);

        double sum = 0;
        for (Score s: movie.getScoreSet()){
            sum = sum + s.getValue();
        }
        double avg = sum / movie.getScoreSet().size();

        movie.setScore(avg);
        movie.setCount(movie.getScoreSet().size());

        movie = movieRepository.save(movie);

        return  new MovieDTO(movie);
    }

}
