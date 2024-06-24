package com.example.Gelderse_Kastelen_Java.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Rang")
public class Rang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rang_id")
    private int rangId;
    @Column(name = "rang_naam")
    private String rangNaam;
    @Column(name = "rang_punten")
    private int rangPunten;

    @OneToMany(mappedBy = "rang")
    @JsonBackReference
    private List<User> users;

}
