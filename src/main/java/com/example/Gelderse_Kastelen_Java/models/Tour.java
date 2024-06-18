package com.example.Gelderse_Kastelen_Java.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generate random id
    @Column(name = "tour_id")
    private Integer tourId;
    @NotBlank
    @Column(name = "titel")
    private String titel;
    @NotBlank
    @Column(name = "beschrijving")
    private String beschrijving;
    @NotBlank
    @Column(name = "datum")
    private String datum;
    @NotBlank
    @Column(name = "locatie")
    private String locatie;
    @NotBlank
    @Column(name = "punten")
    private String punten;

    @ManyToOne
  
    @JoinColumn(name="kastelen_kastelen_id", referencedColumnName = "kastelen_id")
    @JsonBackReference
    private Kastelen kastelen;

    
}
