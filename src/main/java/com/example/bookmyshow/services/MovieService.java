package com.example.bookmyshow.services;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository, ActorRepository actorRepository){
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public Movie createMovie(String name){
        Movie movie = new Movie();
        movie.setName(name);
        return movieRepository.save(movie);
    }
}
