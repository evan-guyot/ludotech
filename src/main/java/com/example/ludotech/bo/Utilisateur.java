package com.example.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public abstract class Utilisateur {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length = 255, nullable = false)
	private String nom;
	
	@Column(length = 255, nullable = false)
	private String prenom;
}
