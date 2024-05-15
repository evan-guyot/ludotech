package com.example.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludotech.bo.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}