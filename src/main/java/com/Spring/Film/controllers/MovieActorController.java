package com.Spring.Film.controllers;

import com.Spring.Film.models.MovieActor;
import com.Spring.Film.models.MovieActorId;
import com.Spring.Film.services.MovieActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieActors")
public class MovieActorController {
    @Autowired
    private MovieActorService movieActorService;

    public MovieActorController() {
    }

    public MovieActorController(MovieActorService movieActorService) {
        this.movieActorService = movieActorService;
    }

    public MovieActorService getMovieActorService() {
        return movieActorService;
    }

    public void setMovieActorService(MovieActorService movieActorService) {
        this.movieActorService = movieActorService;
    }
    @GetMapping
    public ResponseEntity<List<MovieActor>> getAllMovieActors(){
        return ResponseEntity.ok(movieActorService.getAllMovieActors());
    }
    @GetMapping("/{movieId}/{actorId}")
    public ResponseEntity<MovieActor> getMovieActorById(@PathVariable Long movieId, @PathVariable Long actorId){
        MovieActorId id = new MovieActorId(movieId,actorId);
        return movieActorService.getMovieActorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<MovieActor> saveMovieActor(@RequestBody MovieActor movieActor){
        return ResponseEntity.ok(movieActorService.saveMovieActor(movieActor));
    }
    @DeleteMapping("/{movieId}/{actorId}")
    public ResponseEntity<Void> deleteMovieActor(@PathVariable Long movieId, @PathVariable Long actorId){
        MovieActorId id = new MovieActorId(movieId,actorId);
        if(movieActorService.getMovieActorById(id).isPresent()){
            movieActorService.deleteMovieActor(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }

    }


}

