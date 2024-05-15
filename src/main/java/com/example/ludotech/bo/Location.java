package com.example.ludotech.bo;

import java.util.Date;

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
public class Location {
	@Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date dateDebut;
    
    @Column(nullable = false)
    private Boolean estPaye;
}
