package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.User;
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
    @PostMapping
    public User postUser(@RequestBody User user) {
        return userService.postUser(user);
    }

    // Patch method for updating users
    @PatchMapping(value = "/patch/user/{id}")
    public User patchUser(@PathVariable(value = "id", required = false) int id,
            @RequestBody Map<String, Object> fields) {
        return userService.patchUser(id, fields);
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

}
