package com.example.ludotech.dal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.ludotech.bo.Client;
import com.example.ludotech.bo.Reservation;
import com.example.ludotech.dal.ReservationRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ReservationRepositoryTest {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	@DisplayName("Test ajout d'une réservation")
	void testSave() {
		// Arrange
		Client client = new Client();
		client.setNom("Doe");
		client.setPrenom("John");
		client.setTelephone("0123456789");
		entityManager.persist(client);

		Reservation reservation = new Reservation();
		reservation.setDateReservation(new Date());
		reservation.setClient(client);

		// Act
		Reservation savedReservation = reservationRepository.save(reservation);

		// Assert
		assertThat(savedReservation.getId()).isNotNull();
	}

	@Test
	@DisplayName("Test recherche d'une réservation par ID")
	void testFindById() {
		// Arrange
		Client client = new Client();
		client.setNom("Doe");
		client.setPrenom("John");
		client.setTelephone("0123456789");
		entityManager.persist(client);

		Reservation reservation = new Reservation();
		reservation.setDateReservation(new Date());
		reservation.setClient(client);
		entityManager.persist(reservation);

		// Act
		Optional<Reservation> foundReservation = reservationRepository.findById(reservation.getId());

		// Assert
		assertTrue(foundReservation.isPresent());
		assertEquals(reservation, foundReservation.get());
	}
}
