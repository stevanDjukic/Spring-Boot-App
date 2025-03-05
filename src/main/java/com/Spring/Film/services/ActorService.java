package com.Spring.Film.services;

import com.Spring.Film.models.Actor;
import com.Spring.Film.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public ActorService() {
    }

    public ActorRepository getActorRepository() {
        return actorRepository;
    }

    public void setActorRepository(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    public Optional<Actor> findActorById(Long id){
        return actorRepository.findById(id);
    }

    public Actor saveActor(Actor actor){
        return actorRepository.save(actor);
    }

    public void deleteActor(Long id){
        actorRepository.deleteById(id);
    }


}
