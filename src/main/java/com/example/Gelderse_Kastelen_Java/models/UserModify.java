package com.example.Gelderse_Kastelen_Java.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserModify {
    // Specify which columns needs to be used from the db
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generate random id
    @Column(name = "user_id")
    private Integer userId;
    @NotBlank
    @Column(name = "naam")
    private String naam;
    @NotBlank
    @Column(name = "achternaam")
    private String achternaam;
    @NotBlank
    @Column(name = "email")
    private String email;
    @NotBlank
    @Column(name = "wachtwoord")
    private String wachtwoord;
    @NotBlank
    @Column(name = "rang")
    private String rang;
    @NotBlank
    @Column(name = "punten")
    private String punten;
    @NotBlank
    @Column(name = "rol")
    private String rol;
}
