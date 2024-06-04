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
@Table(name = "activiteiten") // Specify which table needs to be used from the db
public class Activiteiten {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activiteiten_id")
    private int employerId;
    @Column(name = "type")
    private String type;
    @Column(name = "punten_verdiend")
    private String puntenVerdiend;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "activiteiten_has_kastelen", joinColumns = @JoinColumn(name = "activiteiten_activiteiten_id", referencedColumnName = "activiteiten_id"), inverseJoinColumns = @JoinColumn(name = "kastelen_kastelen_id", referencedColumnName = "kastelen_id"))
    private List<Kastelen> kastelen;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "activiteiten_has_user", joinColumns = @JoinColumn(name = "activiteiten_activiteiten_id", referencedColumnName = "activiteiten_id"), inverseJoinColumns = @JoinColumn(name = "user_user_id", referencedColumnName = "user_id"))
    private List<User> users;
}
