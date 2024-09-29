package com.example.moviebooking.service;

import com.example.moviebooking.dto.ScreeningDTO;
import com.example.moviebooking.model.Screening;
import com.example.moviebooking.repository.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService {
    @Autowired
    private ScreeningRepository screeningRepository;

    public List<ScreeningDTO> getAllScreenings() {
        return screeningRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ScreeningDTO convertToDTO(Screening screening) {
        ScreeningDTO dto = new ScreeningDTO();
        dto.setId(screening.getId());
        dto.setMovieId(screening.getMovie().getId());
        dto.setStartTime(screening.getStartTime());
        dto.setAvailableSeats(screening.getAvailableSeats());
        return dto;
    }
}