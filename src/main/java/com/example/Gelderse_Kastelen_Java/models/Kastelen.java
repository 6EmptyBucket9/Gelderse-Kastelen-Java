package com.example.Gelderse_Kastelen_Java.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "Kastelen")
public class Kastelen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generate random id
    @Column(name = "kastelen_id")
    private Integer kastelenId;
    @NotBlank
    @Column(name = "naam")
    private String naam;
    @NotBlank
    @Column(name = "beschrijving")
    private String beschrijving;
    @NotBlank
    @Column(name = "locatie")
    private String locatie;
    @NotBlank
    @Column(name = "kastelen_img_url")
    private String kastelenImgUrl;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "kastelen_has_content", joinColumns = @JoinColumn(name = "kastelen_kastelen_id", referencedColumnName = "kastelen_id"), inverseJoinColumns = @JoinColumn(name = "content_content_id", referencedColumnName = "content_id"))
    private List<Content> contents;

    @OneToMany(mappedBy = "kastelen")
    @JsonManagedReference
    private List<Tour> tours;
}
