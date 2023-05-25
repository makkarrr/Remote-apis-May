package com.example.clientdemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
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
