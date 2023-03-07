package com.example.bookmyshow.controllers;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class MovieController {

    private MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }
    public Movie createMovie(String name){
        return movieService.createMovie(name);
    }
}
