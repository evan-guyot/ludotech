package com.example.ludotech.bo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"location", "exemplaire"}) 
@Entity
public class LocationExemplaire {
	
	@Id
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Id
    @ManyToOne
    @JoinColumn(name = "exemplaire_id")
    private Exemplaire exemplaire;


    @Column(nullable = true)
    private Date dateFin;

    @Column(nullable = true)
    private Float prixFinal;

}
