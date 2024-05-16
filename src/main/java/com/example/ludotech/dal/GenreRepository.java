package com.example.ludotech.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludotech.bo.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
