package com.movie.movie.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.movie.movie.customError.MovieNotFound;
import com.movie.movie.model.Movie;
import com.movie.movie.repository.MovieRepos;

@Service
public class MovieServices {
    @Autowired
    MovieRepos movieRepos;

    public List<Movie> getAllMovies()
    {
        return movieRepos.findAll();
    }

    
    public ResponseEntity<Movie>  getMovie(ObjectId id)
    {
        Optional<Movie> movie = movieRepos.findById(id);
        try{
            if(movie.isPresent())
        {
            return new ResponseEntity<>(movie.get(),HttpStatus.ACCEPTED);
        }
        throw new MovieNotFound();
        }
        catch(Exception e)
        {
               return  new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
        
    }
}
