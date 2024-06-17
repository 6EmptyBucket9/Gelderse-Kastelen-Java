package com.example.Gelderse_Kastelen_Java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gelderse_Kastelen_Java.models.TourCalendar;
import com.example.Gelderse_Kastelen_Java.repositories.TourRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TourService {

    @Autowired
    TourRepository tourRepository;

    // Get method
    public Iterable<TourCalendar> getTours() {
        try {
            return tourRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tourRepository.findAll();
    }

}
