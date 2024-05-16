package com.example.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludotech.bo.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}