package com.Spring.Film.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;
    @Column(nullable = false)
    private int year;

    @ManyToMany
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieActor> actors;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MovieScore> scores;

    public double getAverageScore(){
        return scores.stream().mapToDouble(MovieScore::getScore).average().orElse(0.0);
    }

    private Movie(){}

    public Movie(Long id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public List<MovieActor> getActors() {
        return actors;
    }

    public void setActors(List<MovieActor> actors) {
        this.actors = actors;
    }

    public List<MovieScore> getScores() {
        return scores;
    }

    public void setScores(List<MovieScore> scores) {
        this.scores = scores;
    }
}
