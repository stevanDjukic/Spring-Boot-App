package com.Spring.Film.services;

import com.Spring.Film.models.Movie;
import com.Spring.Film.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public MovieService() {
    }

    public MovieRepository getMovieRepository() {
        return movieRepository;
    }

    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie saveMovie(Movie Movie){
        return movieRepository.save(Movie);
    }

    public Optional<Movie> getMovieById(Long id){
        return movieRepository.findById(id);
    }

    public void deleteMovie(Long Id){
        movieRepository.deleteById(Id);
    }

}
