package com.movie.movie.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.movie.model.Movie;
import com.movie.movie.service.MovieServices;

@RestController

public class MovieController {
    @Autowired
    MovieServices movieServices;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movies()
    {
        return new ResponseEntity<>(movieServices.getAllMovies(),HttpStatus.ACCEPTED);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable ObjectId id)
    {
        // ObjectId newId = new ObjectId(id);
        return movieServices.getMovie(id);
    }
}
