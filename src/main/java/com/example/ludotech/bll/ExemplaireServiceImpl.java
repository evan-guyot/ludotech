package com.example.ludotech.bll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ludotech.bo.Client;
import com.example.ludotech.bo.Exemplaire;
import com.example.ludotech.bo.Reservation;
import com.example.ludotech.dal.ClientRepository;
import com.example.ludotech.dal.ExemplaireRepository;
import com.example.ludotech.dal.ModeleRepository;
import com.example.ludotech.dal.ReservationRepository;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
   
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private ModeleRepository modeleRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ExemplaireRepository exemplaireRepository;
	
	
	@Override
	public List<Exemplaire> ReserverExemplaire(Integer clientId, List<Integer> listModeleId) throws Exception {

		
		if(listModeleId.size() > 3) {
			throw new Exception("Vous ne pouvez pas réserver plus de 3 exemplaires à la fois");
		}
		
		Optional<Client> client = clientRepository.findById(clientId);
		
		if(client.isEmpty()) {
			throw new Exception("Client non trouvé");
		}
		
		
		List<Exemplaire> exemplaires = new ArrayList<>();
		
		Reservation reservation = Reservation.builder()
				.client(client.get())
				.dateReservation(new Date())
				.build();
		
		
		for(Integer modeleId : listModeleId) {
			if(modeleRepository.findById(clientId).isPresent()) {
				Integer idReserve = exemplaireRepository.getReservableExemplaireByModeleId(modeleId).get(0);

				
				if(idReserve != null) {
					
					var exemplaire = exemplaireRepository.findById(idReserve);
					
					if(exemplaire.isPresent()) {
						exemplaires.add(exemplaire.get());						
					}
				}else {
					throw new Exception("Aucun exemplaire disponible");
				}
			}
			else {
				throw new Exception("Modele non trouvé : " + modeleId);				
			}
		}



		reservation.setExemplaires(exemplaires);
		

		reservationRepository.save(reservation);
		
		
		return exemplaires;
	}

}
