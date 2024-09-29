package com.example.moviebooking.controller;

import com.example.moviebooking.dto.ScreeningDTO;
import com.example.moviebooking.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    @Autowired
    private ScreeningService screeningService;

    @GetMapping
    public List<ScreeningDTO> getAllScreenings() {
        return screeningService.getAllScreenings();
    }
}