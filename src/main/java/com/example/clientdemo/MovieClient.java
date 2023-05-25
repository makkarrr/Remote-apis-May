package com.example.clientdemo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class MovieClient {
    //private static String url = "https://api.themoviedb.org/3/movie/%s?api_key=cd46fe13f1442cfa663d94a7d3ed7e5e";

    private static String key = "cd46fe13f1442cfa663d94a7d3ed7e5e";
    private static String POST_MOVIE_URL = "https://api.themoviedb.org/3/movie?api_key=%s";

    private static String UPDATE_MOVIE_PATH = "/update-movie/%s";
    private static String GET_MOVIE_PATH = "/movie/%s";
    private static String baseUrl = "https://api.themoviedb.org/3";
    RestTemplate restTemplate = new RestTemplate();
    public Movie getMovie(Integer id) {
        String url2 = UriComponentsBuilder
                .fromHttpUrl(baseUrl)    //https://moviedb.org/3
                .path(String.format(GET_MOVIE_PATH, id)) // /movie/530
                .queryParam("api_key", key) //?api_key=hjfbcvhjevbcksdc
                .build()
                .toUriString();

        //"https://moviedb.org/3/movie/530?api_key=hjfbcvhjevbcksdc"


        ResponseEntity<Movie> Response = restTemplate.exchange(url2, HttpMethod.GET, HttpEntity.EMPTY, Movie.class);
        return Response.getBody();
    }

    public String addMovie(Movie movie) {
        String postUrl = String.format(POST_MOVIE_URL, key);
        HttpEntity entity = new HttpEntity(movie);
        // GET, POST, PUT, DELETE
        ResponseEntity response =  restTemplate.exchange(postUrl, HttpMethod.POST, entity, String.class);
        if( response.getStatusCode().is2xxSuccessful()) {
            return "movie added successfully";
        }
        return "nothing";
    }

    public String updateMovie(Integer id, String updatedTitle) {
        String updateUrl = UriComponentsBuilder
                .fromHttpUrl(baseUrl)
                .path(String.format(UPDATE_MOVIE_PATH, id))
                .queryParam("api_key", key)
                .queryParam("title", updatedTitle)
                .build()
                .toUriString();

        // https:moviedb.org/3/update-movie/530?api_key=84835y273845y&title=harry_potter_2

        ResponseEntity response =  restTemplate.exchange(updateUrl, HttpMethod.PUT, HttpEntity.EMPTY, Movie.class);
        if( response.getStatusCode().is2xxSuccessful()) {
            return "movie added successfully";
        }
        return "nothing";
    }
}
