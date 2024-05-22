package com.example.ludotech.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
@Entity
public class Adresse {
	@Id
    @GeneratedValue
    private Integer id;

    @Column(length = 255, nullable = false)
    private String rue;

    @Column(length = 255, nullable = false)
    private String codePostal;

    @Column(length = 255, nullable = false)
    private String ville;

    @OneToOne  
    @JoinColumn(name="id_client", nullable = false)
    private Client client;
}
