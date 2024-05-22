package com.example.ludotech.bll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ludotech.bo.Adresse;
import com.example.ludotech.bo.Client;
import com.example.ludotech.bo.Exemplaire;
import com.example.ludotech.bo.Modele;
import com.example.ludotech.dal.ClientRepository;
import com.example.ludotech.dal.ExemplaireRepository;
import com.example.ludotech.dal.ModeleRepository;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class ExemplaireServiceTest {
	
    @Autowired
    private ClientRepository clientRepository;
    
    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private ModeleRepository modeleRepository;
    
    @Autowired 
    private ExemplaireService exemplaireService;
    
	@Test
	void test() throws Exception {
		// Arrange
		Modele modeleMonopoly = Modele.builder().nom("Monopoly").prixLocation(3.5f).build();
		Modele modeleElefun = Modele.builder().nom("Elefun").prixLocation(5f).build();

		Exemplaire exemplaireMonopoly = Exemplaire.builder().codeBarre("ae584dax92").estLouable(true).build();
		Exemplaire exemplaireElefun = Exemplaire.builder().codeBarre("ae584dax91").estLouable(true).build();
				
		Client client = Client.builder().nom("Telo").prenom("Emma").telephone("06 66 66 66 66").build();
		
		List<Integer> modeleIds = new ArrayList<Integer>();
		
		// Act
		
		clientRepository.save(client);
		
		modeleRepository.save(modeleElefun);
		modeleRepository.save(modeleMonopoly);
		
		exemplaireElefun.setModele(modeleElefun);
		exemplaireMonopoly.setModele(modeleMonopoly);
		
		exemplaireRepository.save(exemplaireElefun);
		exemplaireRepository.save(exemplaireMonopoly);


		modeleIds.add(exemplaireElefun.getId());
		modeleIds.add(exemplaireMonopoly.getId());	
		
		List<Exemplaire> result = exemplaireService.ReserverExemplaire(client.getId(), modeleIds);
		
		
		
		// Assert
		assertFalse(result.isEmpty());
		 
		assertTrue(result.get(0).getEstLouable());
	}
}
