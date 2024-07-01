package com.example.Gelderse_Kastelen_Java.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import com.example.Gelderse_Kastelen_Java.models.Foto;
import com.example.Gelderse_Kastelen_Java.services.FotoService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/v1/fotos")
public class FotoController {

    @Autowired
    FotoService fotoService;
    
    //Method to get post
    @GetMapping
    public Iterable<Foto> getFoto() {
        return fotoService.getFoto();
    }

    //Method to post the foto and link to user
    @PostMapping(value="/post/foto/{userId}/{kasteelId}",  consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Transactional
    public ResponseEntity<Foto> createFotoAndLinkToUsers(@PathVariable int userId, @PathVariable int kasteelId, @RequestPart(name="files") MultipartFile files) {
        return fotoService.postFoto(userId, kasteelId, files);
    
    }
}