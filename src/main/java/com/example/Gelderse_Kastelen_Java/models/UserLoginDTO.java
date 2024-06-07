<<<<<<<< HEAD:src/main/java/com/example/Gelderse_Kastelen_Java/models/UserRegisterDTO.java
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
========
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
>>>>>>>> d66913d7d0b9e155ca8da4cc052f7391956b0e7d:src/main/java/com/example/Gelderse_Kastelen_Java/models/UserLoginDTO.java
