package com.example.Gelderse_Kastelen_Java.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserModify {

    private Integer userId;
    private String naam;
    private String achternaam;
    private String email;
    private String wachtwoord;
    private String punten;
    private String rol;
}
