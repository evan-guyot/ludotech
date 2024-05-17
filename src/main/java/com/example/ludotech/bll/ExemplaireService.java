package com.example.ludotech.bll;

import java.util.List;

import com.example.ludotech.bo.Exemplaire;

public interface ExemplaireService {
	public List<Exemplaire> ReserverExemplaire(Integer clientId, List<Integer> listModeleId) throws Exception;
}
