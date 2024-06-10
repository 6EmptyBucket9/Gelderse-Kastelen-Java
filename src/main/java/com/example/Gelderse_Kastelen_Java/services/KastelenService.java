package com.example.Gelderse_Kastelen_Java.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gelderse_Kastelen_Java.models.Kastelen;
import com.example.Gelderse_Kastelen_Java.repositories.KastelenRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class KastelenService {

    @Autowired
    KastelenRepository kastelenRepository;

    // Get method
    public Iterable<Kastelen> getKastelen() {
        try {
            return kastelenRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kastelenRepository.findAll();
    }

    // Get by id method

    // Post method
    public Kastelen postKasteel(Kastelen kasteel) {
        try {
            kastelenRepository.save(kasteel);
            return kasteel;
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("An unexpected error occurred while registering the user.", e);
        }
    }

    // Get by ID method
    public Optional<Kastelen> getKasteelById(int id) {

        try {
            return kastelenRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kastelenRepository.findById(id);
    }

}
