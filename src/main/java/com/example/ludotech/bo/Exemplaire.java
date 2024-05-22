package com.example.ludotech.bo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
@Entity
@Table
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
	
	@OneToMany(mappedBy = "exemplaire")
	private List<LocationExemplaire> locations = new ArrayList<>();
}
