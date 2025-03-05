package com.Spring.Film.services;

import com.Spring.Film.models.MovieScore;
import com.Spring.Film.repositories.MovieScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieScoreService {
    @Autowired
    private MovieScoreRepository movieScoreRepository;

    public MovieScoreService() {
    }

    public MovieScoreService(MovieScoreRepository movieScoreRepository) {
        this.movieScoreRepository = movieScoreRepository;
    }

    public MovieScoreRepository getMovieScoreRepository() {
        return movieScoreRepository;
    }

    public void setMovieScoreRepository(MovieScoreRepository movieScoreRepository) {
        this.movieScoreRepository = movieScoreRepository;
    }

    public List<MovieScore> getAllMovieScores(){
        return movieScoreRepository.findAll();
    }

    public Optional<MovieScore> getMovieScoreById(Long id){
        return movieScoreRepository.findById(id);
    }

    public MovieScore saveMovieScore(MovieScore movieScore){
        return movieScoreRepository.save(movieScore);
    }

    public void deleteMovieScore(Long id){
        movieScoreRepository.deleteById(id);
    }


}
