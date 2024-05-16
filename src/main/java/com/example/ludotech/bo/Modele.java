package com.example.ludotech.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Modele {

	@Id
	@GeneratedValue
	private Integer id;
	

	@Column(length = 255, nullable = false)
	private String nom;

	@Column(nullable = false)
	private Float prixLocation;
	

    @OneToMany(mappedBy = "modele", cascade = CascadeType.ALL)
    private List<Exemplaire> exemplaires = new ArrayList<>();
    
    @ManyToMany
    @JoinTable(name = "modele_genre")
    private List<Genre> genres = new ArrayList<>();
	 
}
