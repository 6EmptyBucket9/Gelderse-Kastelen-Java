package com.example.Gelderse_Kastelen_Java.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "User") // Specify which table needs to be used from the db
public class User {
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_tour", joinColumns = @JoinColumn(name = "user_user_id", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "tour_tour_id", referencedColumnName = "tour_id"))
    private List<Tour> tour;

    @OneToMany(mappedBy = "user")
    private List<Foto> fotos;
}
