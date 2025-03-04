package com.Spring.Film.repositories;

import com.Spring.Film.models.MovieActor;
import com.Spring.Film.models.MovieActorId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieActorRepository extends JpaRepository<MovieActor, MovieActorId> {
}
