package com.example.Gelderse_Kastelen_Java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.TourCalendar;
import com.example.Gelderse_Kastelen_Java.services.TourService;


@RestController
@RequestMapping(value = "/api/v1/tours")
public class TourController {
    
    @Autowired
    TourService tourService;

    // GET Method to get all Tours
    @GetMapping
    public Iterable<TourCalendar> getTours() {
        return tourService.getTours();
    }

    // POST Method to get all Tours
    @PostMapping(value="/create")
    public TourCalendar postTour(@RequestBody TourCalendar tour) {
        return tourService.postTour(tour);
    }

}
