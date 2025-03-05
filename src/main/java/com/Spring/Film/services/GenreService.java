package com.Spring.Film.services;

import com.Spring.Film.models.Genre;
import com.Spring.Film.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public GenreService() {
    }

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public GenreRepository getGenreRepository() {
        return genreRepository;
    }

    public void setGenreRepository(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(String id){
        return genreRepository.findById(id);
    }

    public Genre saveGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public void deleteGenre(String id){
        genreRepository.deleteById(id);
    }


}
