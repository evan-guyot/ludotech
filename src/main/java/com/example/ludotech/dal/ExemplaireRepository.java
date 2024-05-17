package com.example.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ludotech.bo.Exemplaire;

public interface ExemplaireRepository  extends JpaRepository<Exemplaire, Integer>{
	
	@Query("SELECT exemplaire.id "
			+ "FROM exemplaire "
				+ "JOIN modele ON modele.id = exemplaire.id_modele "
				+ "LEFT JOIN location_exemplaire ON location_exemplaire.exemplaire_id = exemplaire.id "
			+ "WHERE exemplaire.est_louable = 1 "
			+ "AND exemplaire.id_reservation IS NULL "
			+ "AND location_exemplaire.date_fin IS NULL "
			+ "AND exemplaire.id_modele = :modeleId ")
	Integer getReservableExemplaireByModeleId(@Param("modeleId") Integer modeleId);
	

}
