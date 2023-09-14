package com.movie.movie.customError;

public class MovieNotFound extends Exception{
    public MovieNotFound()
    {
        super("Movie not found error");
    }
}
