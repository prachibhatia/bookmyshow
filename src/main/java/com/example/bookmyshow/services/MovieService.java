package com.example.bookmyshow.services;

import com.example.bookmyshow.models.City;
import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    private MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
}
