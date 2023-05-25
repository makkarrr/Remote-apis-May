package com.example.clientdemo;

import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MovieRepository {
    private Map<String, Movie> movieData = new HashMap<>();

    public void addMovie(Movie movie) {
        movieData.put(movie.getImdb_id(), movie);
    }
}
