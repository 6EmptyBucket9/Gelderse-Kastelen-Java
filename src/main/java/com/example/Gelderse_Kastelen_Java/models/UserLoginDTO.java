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
public class UserLoginDTO {
    private String userEmail;
    private String userName;
    private String userRole;
    private String userRang;
}
