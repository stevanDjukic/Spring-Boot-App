package com.Spring.Film.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "actor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MovieActor> movies;

    public Actor() {
    }

    public Actor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieActor> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieActor> movies) {
        this.movies = movies;
    }
}
