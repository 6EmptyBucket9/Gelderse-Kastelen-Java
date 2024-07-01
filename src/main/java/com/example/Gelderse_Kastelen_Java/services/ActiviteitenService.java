package com.example.Gelderse_Kastelen_Java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Gelderse_Kastelen_Java.models.Activiteiten;
import com.example.Gelderse_Kastelen_Java.models.Kastelen;
import com.example.Gelderse_Kastelen_Java.repositories.ActiviteitenRepository;
import com.example.Gelderse_Kastelen_Java.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActiviteitenService {
    
    @Autowired
    ActiviteitenRepository activiteitenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private EntityManager entityManager;

    // Get method
    public Iterable<Activiteiten> getActiviteiten() {
        try {
            return activiteitenRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activiteitenRepository.findAll();
    }

    // Post Method
    public ResponseEntity<Activiteiten> postActiviteiten(int kastelenId, Activiteiten activiteiten) {
        try {
            entityManager.persist(activiteiten);

            // Find the existing Kastelen entity
            Kastelen kastelen = entityManager.find(Kastelen.class, kastelenId);

            if (kastelen == null) {
                return ResponseEntity.notFound().build();
            }
            // Establish the relationship
            activiteiten.getKastelen().add(kastelen);

            // Persist the changes
            entityManager.merge(kastelen);

            // Return the persisted activiteiten entity
            return ResponseEntity.ok(activiteiten);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }


}
