package com.Spring.Film.controllers;

import com.Spring.Film.models.Actor;
import com.Spring.Film.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    public ActorController() {
    }

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    public ActorService getActorService() {
        return actorService;
    }

    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors(){
        return ResponseEntity.ok(actorService.getAllActors());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id){
        return actorService.findActorById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Actor> saveActor(@RequestBody Actor actor){
        return ResponseEntity.ok(actorService.saveActor(actor));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id){
        if(actorService.findActorById(id).isPresent()) {
            actorService.deleteActor(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
