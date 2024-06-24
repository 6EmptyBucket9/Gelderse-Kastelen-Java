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

    // Post method
    public TourCalendar postTour(TourCalendar tour) {
        try {
            tourRepository.save(tour);
            return tour;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("An unexpected error occured while posting tour.", e);
        }
    }

}
