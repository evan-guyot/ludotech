package com.example.ludotech.dal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ludotech.bo.Exemplaire;

public interface ExemplaireRepository  extends JpaRepository<Exemplaire, Integer> {	
	@Query("SELECT e.id FROM Exemplaire e JOIN e.modele m LEFT JOIN e.locations l WHERE e.estLouable = true AND e.reservation.id IS NULL AND l.dateFin IS NULL AND e.modele.id = :modeleId")
	List<Integer> getReservableExemplaireByModeleId(@Param("modeleId") Integer modeleId);
	

}
