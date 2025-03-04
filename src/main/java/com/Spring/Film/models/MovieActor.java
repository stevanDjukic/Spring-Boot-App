package com.Spring.Film.models;


import jakarta.persistence.*;


@Entity
@Table(name = "movie_actor")
public class MovieActor {
    @EmbeddedId
    private MovieActorId id;


    @ManyToOne
    @MapsId("movie_id")
    private Movie movie;
    @ManyToOne
    @MapsId("actor_id")
    private Actor actor;
    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private double score;

    public MovieActor() {
    }

    public MovieActor(MovieActorId id, String role, double score) {
        this.id = id;
        this.role = role;
        this.score = score;
    }

    public MovieActorId getId() {
        return id;
    }

    public void setId(MovieActorId id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
