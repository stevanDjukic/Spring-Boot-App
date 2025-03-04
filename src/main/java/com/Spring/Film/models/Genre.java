package com.Spring.Film.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    private String name;
    @ManyToMany(mappedBy = "genres")
    private Set<Movie> movies;

    public Genre() {
    }

    public Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
