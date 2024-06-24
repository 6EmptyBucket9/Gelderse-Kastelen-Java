package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.Content;
import com.example.Gelderse_Kastelen_Java.services.ContentService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(value = "/api/v1/contents")
public class ContentController {

    @Autowired
    ContentService contentService;


    @PatchMapping(value = "/patch/contents/{id}")
    public ResponseEntity<?> patchContents(@PathVariable("id") int id, @RequestBody Map<String, Object> fields) {
        contentService.patchContent(id, fields);
        return null;

    }

    @PostMapping("/post/content/{kastelenId}")
    @Transactional
    public ResponseEntity<Content> createContentAndLinkToKastelen(@PathVariable int kastelenId, @RequestBody Content content) {
        return contentService.postContent(kastelenId, content);
    
    }
}