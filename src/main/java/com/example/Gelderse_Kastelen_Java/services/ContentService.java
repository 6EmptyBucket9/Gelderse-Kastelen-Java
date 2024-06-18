package com.example.Gelderse_Kastelen_Java.services;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.Gelderse_Kastelen_Java.models.Content;
import com.example.Gelderse_Kastelen_Java.repositories.ContentRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    public ResponseEntity<?> patchContent(int id, Map<String, Object> fields) {
        try {
            Optional<Content> existingContent = contentRepository.findById(id);
            if (existingContent.isPresent()) {
                fields.forEach((key, value) -> { // Map through fields
                    Field field = ReflectionUtils.findField(Content.class, key);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, existingContent.get(), value);
                });
            }
            return null;
        } catch (

        Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}
