package com.example.clientdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieClient movieClient = new MovieClient();

    @Autowired
    private MovieRepository movieRepository;
    public Movie getMovieFromMovieClient(Integer id) {
        Movie movie = movieClient.getMovie(id);
        //movieRepository.addMovie(movie);
        return movie;
    }
}
