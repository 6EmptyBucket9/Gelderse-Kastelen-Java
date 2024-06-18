package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.services.ContentService;

@RestController
@RequestMapping(value = "/api/v1/contents")
public class ContentController {

    @Autowired
    ContentService contentService;

    // GET Method to get all kastelen
  @PatchMapping(value = "/patch/contents/{id}")
  public ResponseEntity<?> patchContents(@PathVariable("id") int id, @RequestBody Map<String, Object> fields) {
    contentService.patchContent(id, fields);
                return null;

}
}