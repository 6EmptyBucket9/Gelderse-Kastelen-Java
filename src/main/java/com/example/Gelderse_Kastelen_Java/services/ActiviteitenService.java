package com.example.Gelderse_Kastelen_Java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.Gelderse_Kastelen_Java.models.Activiteiten;
import com.example.Gelderse_Kastelen_Java.models.Kastelen;
import com.example.Gelderse_Kastelen_Java.models.User;
import com.example.Gelderse_Kastelen_Java.repositories.ActiviteitenRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ActiviteitenService {

    @Autowired
    ActiviteitenRepository activiteitenRepository;

    @Autowired
    private EntityManager entityManager;

        public Iterable<Activiteiten> getActiviteit() {

        try {

            return activiteitenRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return activiteitenRepository.findAll();
    }
    //Link activity to user for testing purpose
    public ResponseEntity<?> linkActiviteitToUser(int userId, int activiteitenId) {
        try {

            Activiteiten activiteit = entityManager.find(Activiteiten.class, activiteitenId);
            entityManager.persist(activiteit);
            // Find the existing User entity
            User user = entityManager.find(User.class, userId);

            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            // Establish the relationship
        
            activiteit.getUsers().add(user);
        
            // Persist the changes
            entityManager.merge(activiteit);

            // Return the persisted Content entity
            return ResponseEntity.ok(activiteit);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    //Link activity to kastelen for tesitng
    public ResponseEntity<?> linkActiviteitenToKastelen(int kasteelId, int activiteitenId) {
        try {

            Activiteiten activiteit = entityManager.find(Activiteiten.class, activiteitenId);
            entityManager.persist(activiteit);
            // Find the existing User entity
            Kastelen kasteel = entityManager.find(Kastelen.class, kasteelId);

            if (kasteel == null) {
                return ResponseEntity.notFound().build();
            }
            // Establish the relationship
        
            activiteit.getKastelen().add(kasteel);
        
            // Persist the changes
            entityManager.merge(activiteit);

            // Return the persisted Content entity
            return ResponseEntity.ok(activiteit);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}