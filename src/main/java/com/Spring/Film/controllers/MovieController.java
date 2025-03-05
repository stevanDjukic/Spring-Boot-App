package com.Spring.Film.controllers;

import com.Spring.Film.models.Movie;
import com.Spring.Film.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    public MovieController() {
    }

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public MovieService getMovieService() {
        return movieService;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return movieService.getMovieById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        if(movieService.getMovieById(id).isPresent()){
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
