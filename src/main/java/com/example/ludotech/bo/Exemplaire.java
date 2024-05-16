package com.example.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@EqualsAndHashCode(of = "id")
@Entity
public class Exemplaire {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable = false, unique = true)
	private String codeBarre;

	@Column(nullable = false)
	private Boolean estLouable;

	@ManyToOne
	@JoinColumn(name = "id_modele", nullable = true)
	private Modele modele;

	@ManyToOne
	@JoinColumn(name = "id_reservation", nullable = true)
	private Reservation reservation;
}
