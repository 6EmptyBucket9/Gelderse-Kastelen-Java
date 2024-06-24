package com.example.Gelderse_Kastelen_Java.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
@Table(name = "foto") // Specify which table needs to be used from the db
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foto_id")
    private int fotoId;
    @Lob
    @Column(name = "foto_upload")
    private byte[] fotoUpload;
    @Column(name = "foto_col")
    private String fotoCol;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="user_user_id", referencedColumnName = "user_id")
    private User user;
}
