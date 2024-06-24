package com.example.Gelderse_Kastelen_Java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Gelderse_Kastelen_Java.models.Foto;
import com.example.Gelderse_Kastelen_Java.models.User;
import com.example.Gelderse_Kastelen_Java.repositories.FotoRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class FotoService {

    @Autowired
    FotoRepository fotoRepository;

    @Autowired
    private EntityManager entityManager;

    // Get method
    public Iterable<Foto> getFoto() {

        try {

            return fotoRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fotoRepository.findAll();
    }

    // Method to post fotos
    public ResponseEntity<Foto> postFoto(int userId, MultipartFile files) {
        try {
            // set the files to byte
            byte[] byteArr = files.getBytes();

            Foto foto = new Foto();

            entityManager.persist(foto);
            
            foto.setFotoCol(files.getOriginalFilename());
      
            foto.setFotoUpload(byteArr);
            // Find the existing user entity
            User user = entityManager.find(User.class, userId);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }
            // Establish the relationship
            foto.setUser(user);
            // Persist the changes
            entityManager.merge(foto);

            // Return the persisted Content entity
            return ResponseEntity.ok(foto);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }
}