package com.example.clientdemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/get-movie")
    public Movie getMovie(@RequestParam Integer id) {
        log.info("called api to get movie from moviedb client");
        try {
            return movieService.getMovieFromMovieClient(id);
        } catch(Exception ex) {
            log.error("customer id: jhfvhjv, error in getting movie data for id: " + id);
            log.error(ex.getStackTrace()+ ex.getMessage());
        }
        return null;
    }

}
