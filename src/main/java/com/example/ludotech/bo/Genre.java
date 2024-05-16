package com.example.ludotech.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Genre {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(length = 255, nullable = false)
	private String libelle;
	
	@ManyToMany(mappedBy = "genres")
	private List<Modele> modeles = new ArrayList<>();
}
