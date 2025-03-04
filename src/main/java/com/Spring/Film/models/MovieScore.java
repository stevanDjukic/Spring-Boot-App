package com.Spring.Film.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_scores")
public class MovieScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score;
    @ManyToOne
    @JoinColumn(name = "movie_id",nullable = false)
    private Movie movie;

    public MovieScore() {
    }

    public MovieScore(Long id, double score, Movie movie) {
        this.id = id;
        this.score = score;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
