package com.example.Gelderse_Kastelen_Java.services;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.Gelderse_Kastelen_Java.models.Content;
import com.example.Gelderse_Kastelen_Java.models.Kastelen;
import com.example.Gelderse_Kastelen_Java.repositories.ContentRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ContentService {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    private EntityManager entityManager;

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
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ResponseEntity<Content> postContent(int kastelenId, Content content) {
        try {
            entityManager.persist(content);

            // Find the existing Kastelen entity
            Kastelen kastelen = entityManager.find(Kastelen.class, kastelenId);

            if (kastelen == null) {
                return ResponseEntity.notFound().build();
            }
            // Establish the relationship
            kastelen.getContents().add(content);

            // Persist the changes
            entityManager.merge(kastelen);

            // Return the persisted Content entity
            return ResponseEntity.ok(content);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}