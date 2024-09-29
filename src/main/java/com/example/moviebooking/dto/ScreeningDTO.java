package com.example.moviebooking.dto;

import java.time.LocalDateTime;

public class ScreeningDTO {
    private Long id;
    private Long movieId;
    private LocalDateTime startTime;
    private int availableSeats;

    // Getters
    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}