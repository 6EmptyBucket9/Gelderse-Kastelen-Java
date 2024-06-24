package com.example.Gelderse_Kastelen_Java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.Activiteiten;
import com.example.Gelderse_Kastelen_Java.services.ActiviteitenService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/v1/activiteiten")
public class ActiviteitenController {
    
    @Autowired
    ActiviteitenService activiteitenService;

    // GET Method to get all activiteiten
    @GetMapping
    public Iterable<Activiteiten> getActiviteiten() {
        return activiteitenService.getActiviteiten();
    }

    /// POST Method te create a activiteit
    @PostMapping("/post/activiteit/{kastelenId}")
    @Transactional
    public ResponseEntity<Activiteiten> createActiviteitAndLinkToKastelen(@PathVariable int kastelenId, @RequestBody Activiteiten activiteiten) {
        return activiteitenService.postActiviteiten(kastelenId, activiteiten);
    
    }

}
