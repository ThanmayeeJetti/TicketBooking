package com.example.moviebooking.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screening_id")
    private Screening screening;

    private String customerName;
    private int numberOfSeats;

    // Getters
    public Long getId() {
        return id;
    }

    public Screening getScreening() {
        return screening;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}