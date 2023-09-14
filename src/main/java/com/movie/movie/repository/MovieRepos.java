package com.movie.movie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoDatabase;
import com.movie.movie.model.Movie;




@Repository
public interface MovieRepos extends MongoRepository<Movie,ObjectId>{
        
}
