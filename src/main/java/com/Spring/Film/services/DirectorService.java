package com.Spring.Film.services;

import com.Spring.Film.models.Director;
import com.Spring.Film.models.Movie;
import com.Spring.Film.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public DirectorService() {
    }

    public DirectorRepository getDirectorRepository() {
        return directorRepository;
    }

    public void setDirectorRepository(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> getAllDirectors(){
        return directorRepository.findAll();
    }

    public Optional<Director> getDirectorById(Long id){
        return directorRepository.findById(id);
    }

    public Director saveDirector(Director director){
        return directorRepository.save(director);
    }

    public void deleteDirector(Long id){
        directorRepository.deleteById(id);
    }

}
