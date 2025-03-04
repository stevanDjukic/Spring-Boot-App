package com.Spring.Film.models;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieActorId implements Serializable {
    private Long movie_id;
    private Long actor_id;

    public MovieActorId() {
    }

    public MovieActorId(Long movie_id, Long actor_id) {
        this.movie_id = movie_id;
        this.actor_id = actor_id;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getActor_id() {
        return actor_id;
    }

    public void setActor_id(Long actor_id) {
        this.actor_id = actor_id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj == null || getClass()!=obj.getClass())return false;
        MovieActorId mov = (MovieActorId) obj;

        return Objects.equals(this.movie_id,mov.getMovie_id()) && Objects.equals(this.actor_id, mov.getActor_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.movie_id,this.actor_id);
    }
}
