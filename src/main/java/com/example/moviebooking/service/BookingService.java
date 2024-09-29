package com.example.moviebooking.service;

import com.example.moviebooking.dto.BookingDTO;
import com.example.moviebooking.model.Booking;
import com.example.moviebooking.model.Screening;
import com.example.moviebooking.repository.BookingRepository;
import com.example.moviebooking.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ScreeningRepository screeningRepository;

    public Long createBooking(BookingDTO bookingDTO) {
        Screening screening = screeningRepository.findById(bookingDTO.getScreeningId())
                .orElseThrow(() -> new RuntimeException("Screening not found"));

        if (screening.getAvailableSeats() < bookingDTO.getNumberOfSeats()) {
            throw new RuntimeException("Not enough seats available");
        }

        Booking booking = new Booking();
        booking.setScreening(screening);
        booking.setCustomerName(bookingDTO.getCustomerName());
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());

        screening.setAvailableSeats(screening.getAvailableSeats() - bookingDTO.getNumberOfSeats());
        screeningRepository.save(screening);

        return bookingRepository.save(booking).getId();
    }
}