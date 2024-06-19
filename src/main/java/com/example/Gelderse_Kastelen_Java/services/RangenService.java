package com.example.Gelderse_Kastelen_Java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gelderse_Kastelen_Java.models.Rang;
import com.example.Gelderse_Kastelen_Java.repositories.RangenRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RangenService {

    @Autowired
    RangenRepository rangenRepository;

    // Get method
    public Iterable<Rang> getRangen() {
        try {
            return rangenRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rangenRepository.findAll();
    }
}
