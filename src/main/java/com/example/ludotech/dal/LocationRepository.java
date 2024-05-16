package com.example.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludotech.bo.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}