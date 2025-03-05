package com.Spring.Film.controllers;

import com.Spring.Film.models.MovieScore;
import com.Spring.Film.services.MovieScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieScore")
public class MovieScoreController {
    @Autowired
    private MovieScoreService movieScoreService;

    public MovieScoreController() {
    }

    public MovieScoreController(MovieScoreService movieScoreService) {
        this.movieScoreService = movieScoreService;
    }

    public MovieScoreService getMovieScoreService() {
        return movieScoreService;
    }

    public void setMovieScoreService(MovieScoreService movieScoreService) {
        this.movieScoreService = movieScoreService;
    }
    @GetMapping
    public ResponseEntity<List<MovieScore>> getAllMovieScores(){
        return ResponseEntity.ok(movieScoreService.getAllMovieScores());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieScore> getMovieScoreById(@PathVariable Long Id){
        return movieScoreService.getMovieScoreById(Id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<MovieScore> saveMovieScore(@RequestBody MovieScore movieScore){
        return ResponseEntity.ok(movieScoreService.saveMovieScore(movieScore));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieScore(@PathVariable Long Id){
        if(movieScoreService.getMovieScoreById(Id).isPresent()){
            movieScoreService.deleteMovieScore(Id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
