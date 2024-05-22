package com.example.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(of="id")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String nom;

    @Column(length = 255, nullable = false)
    private String prenom;

}