package com.Spring.Film.services;

import com.Spring.Film.models.MovieActor;
import com.Spring.Film.models.MovieActorId;
import com.Spring.Film.repositories.MovieActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieActorService {
    @Autowired
    private MovieActorRepository movieActorRepository;

    public MovieActorService() {
    }

    public MovieActorService(MovieActorRepository movieActorRepository) {
        this.movieActorRepository = movieActorRepository;
    }

    public MovieActorRepository getMovieActorRepository() {
        return movieActorRepository;
    }

    public void setMovieActorRepository(MovieActorRepository movieActorRepository) {
        this.movieActorRepository = movieActorRepository;
    }

    public List<MovieActor> getAllMovieActors(){
        return movieActorRepository.findAll();
    }

    public Optional<MovieActor> getMovieActorById(MovieActorId id){
        return movieActorRepository.findById(id);
    }

    public MovieActor saveMovieActor(MovieActor movieActor){
        return movieActorRepository.save(movieActor);
    }

    public void deleteMovieActor(MovieActorId id){
        movieActorRepository.deleteById(id);
    }

}
