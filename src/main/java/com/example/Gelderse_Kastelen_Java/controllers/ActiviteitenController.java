package com.example.Gelderse_Kastelen_Java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Gelderse_Kastelen_Java.models.Activiteiten;

import com.example.Gelderse_Kastelen_Java.services.ActiviteitenService;

@RestController
@RequestMapping(value = "/api/v1/activiteiten")
public class ActiviteitenController {

    @Autowired
    ActiviteitenService activiteitenService;

 
    @GetMapping
    public Iterable<Activiteiten> getActiviteit() {
        return activiteitenService.getActiviteit();
    }
    //Method to link acitiviteit to user
    @PostMapping("/link/activiteit/user")
    public ResponseEntity<?> linkActiviteitenToUser(int userId, int activiteitenId) {
        return activiteitenService.linkActiviteitToUser(userId, activiteitenId);
    }
        //Method to link acitiviteit to kastelen
        @PostMapping("/link/activiteit/kastelen")
        public ResponseEntity<?> linkActiviteitenToKastelen(int kasteelId, int activiteitenId) {
            return activiteitenService.linkActiviteitenToKastelen(kasteelId, activiteitenId);
        }


}