package com.example.Gelderse_Kastelen_Java.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {   
    private String userNaam;
    private String userAchternaam;
    private String userEmail;
    private String userWachtwoord;
    private String userRang;
    private String userRol;
}
