package com.example.ludotech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity
public class Reservation {
	@Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private Date dateReservation;
    
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;


    @OneToMany(mappedBy = "reservation")
    private List<Exemplaire> exemplaires = new ArrayList<>();
    
}
