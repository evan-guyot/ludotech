package com.example.ludotech.dal;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.ludotech.bo.Genre;
import com.example.ludotech.bo.Modele;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ModeleRepositoryTest {

	@Autowired
	private ModeleRepository repo;

	@Test
	@DisplayName("Test ajout d'un modele avec une liste de genres")
	void testSave() {
		//Arrange
		
		Genre genreCoop =  Genre.builder()
				.libelle("Coop")
				.build();

		Genre genreStrategie =  Genre.builder()
				.libelle("Strategie")
				.build();
		
		List<Genre> genres = new ArrayList<Genre>();
		
		Modele modele = Modele.builder()
						.nom("Dupont")
						.prixLocation(2.0f)
						.build();
		
		//Act

		genres.add(genreCoop);
		genres.add(genreStrategie);
		
		
		modele.setGenres(genres);
		
		Modele modeleCree = repo.save(modele);
		
		//Assert
		
		assertThat(modeleCree.getId()).isNotNull();
		
	}
}