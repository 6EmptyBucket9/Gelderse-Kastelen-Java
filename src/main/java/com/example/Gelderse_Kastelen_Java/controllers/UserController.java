package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.User;
import com.example.Gelderse_Kastelen_Java.models.UserRegisterDTO;
import com.example.Gelderse_Kastelen_Java.models.UserLoginDTO;
import com.example.Gelderse_Kastelen_Java.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    // GET Method to get all users
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

    // POST method to post users
    @PostMapping(value = "/create")
    public UserRegisterDTO postUser(@RequestBody UserRegisterDTO user) {
        return userService.postUser(user);
    }

    // Patch method for updating users
    @PatchMapping("/patch/user/{id}")
    public ResponseEntity<?> patchUser(@PathVariable("id") int id, @RequestBody Map<String, Object> fields) {
        // Your service logic here
        userService.patchUser(id, fields);
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, Object> fields) {
        try {
            UserLoginDTO user = userService.validateUser(fields);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }
    }

    @PutMapping("/{userId}/tours/{tourId}")
    public ResponseEntity<?> linkTourToUser(@PathVariable Integer userId, @PathVariable Integer tourId) {
        userService.linkTourToUser(userId, tourId);
        return ResponseEntity.ok("Tour linked to user successfully");
    }

    @PutMapping("/{userId}/activiteiten/{activiteitId}")
    public ResponseEntity<?> linkActiviteitToUser(@PathVariable Integer userId, @PathVariable Integer activiteitId) {
        try{
            userService.linkActiviteitToUser(userId, activiteitId);
            return ResponseEntity.ok("Activiteit linked to user successfully");
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request data");
        }
    }
}
