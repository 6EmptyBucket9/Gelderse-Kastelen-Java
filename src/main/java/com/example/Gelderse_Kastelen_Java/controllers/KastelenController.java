package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.Kastelen;
import com.example.Gelderse_Kastelen_Java.services.KastelenService;


@RestController
@RequestMapping(value = "/api/v1/kastelen")
public class KastelenController {
    
    @Autowired
    KastelenService kastelenService;

    // GET Method to get all kastelen
    @GetMapping
    public Iterable<Kastelen> getKastelen() {
        return kastelenService.getKastelen();
    }

    // GET Method by id

    
    // GET Method to get vacancy by id
    @GetMapping(value = "/{id}")
    public Optional<Kastelen> getVacancyById(@PathVariable int id) {
        return kastelenService.getKasteelById(id);
    }

    
    // POST Method to get all kastelen
     @PostMapping(value="/create")
    public Kastelen postKasteel(@RequestBody Kastelen kasteel) {
        return kastelenService.postKasteel(kasteel);
    }

}
