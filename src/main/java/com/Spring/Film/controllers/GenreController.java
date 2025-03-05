package com.Spring.Film.controllers;

import com.Spring.Film.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Spring.Film.models.Genre;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    public GenreController() {
    }

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    public GenreService getGenreService() {
        return genreService;
    }

    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres(){
        return ResponseEntity.ok(genreService.getAllGenres());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenreById(@PathVariable String id){
        return genreService.getGenreById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
        return ResponseEntity.ok(genreService.saveGenre(genre));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable String id){
        if(genreService.getGenreById(id).isPresent()){
            genreService.deleteGenre(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
