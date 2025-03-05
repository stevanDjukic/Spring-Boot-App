package com.Spring.Film.controllers;

import com.Spring.Film.models.Director;
import com.Spring.Film.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    public DirectorController() {
    }

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    public DirectorService getDirectorService() {
        return directorService;
    }

    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }
    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors(){
        return ResponseEntity.ok(directorService.getAllDirectors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id){
        return directorService.getDirectorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Director> saveDirector(@RequestBody Director director){
        return ResponseEntity.ok(directorService.saveDirector(director));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id){
        if(directorService.getDirectorById(id).isPresent()){
            directorService.deleteDirector(id);
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
