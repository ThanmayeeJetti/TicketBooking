package com.example.moviebooking.dto;

public class BookingDTO {
    private Long screeningId;
    private String customerName;
    private int numberOfSeats;

    // Getters
    public Long getScreeningId() {
        return screeningId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    // Setters
    public void setScreeningId(Long screeningId) {
        this.screeningId = screeningId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}