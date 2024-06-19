package com.example.Gelderse_Kastelen_Java.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.Rang;
import com.example.Gelderse_Kastelen_Java.services.RangenService;



@RestController
@RequestMapping(value = "/api/v1/rangen")
public class RangenController {
    
    @Autowired
    RangenService rangenService;

    // GET Method to get all rangen
    @GetMapping
    public Iterable<Rang> getRangen() {
        return rangenService.getRangen();
    }
}
