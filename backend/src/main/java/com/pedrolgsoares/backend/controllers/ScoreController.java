package com.pedrolgsoares.backend.controllers;

import com.pedrolgsoares.backend.dto.MovieDTO;
import com.pedrolgsoares.backend.dto.ScoreDTO;
import com.pedrolgsoares.backend.services.MovieService;
import com.pedrolgsoares.backend.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {

    @Autowired
    private ScoreService service;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO scoreDTO){
        MovieDTO movieDTO = service.saveScore(scoreDTO);
        return movieDTO;

    }
}
