package com.example.Gelderse_Kastelen_Java.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gelderse_Kastelen_Java.models.User;
import com.example.Gelderse_Kastelen_Java.models.UserRegisterDTO;
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
    @PostMapping(value="/create")
    public UserRegisterDTO postUser(@RequestBody UserRegisterDTO user) {
        return userService.postUser(user);
    }

    // Patch method for updating users
    @PatchMapping(value = "/patch/user/{id}")
    public User patchUser(@PathVariable(value = "id", required = false) int id,
            @RequestBody Map<String, Object> fields) {
        return userService.patchUser(id, fields);
    }

}
