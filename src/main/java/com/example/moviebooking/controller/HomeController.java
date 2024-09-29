package com.example.moviebooking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index"; // This will look for index.html in the static folder
    }
}