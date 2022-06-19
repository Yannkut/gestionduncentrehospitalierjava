package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Facture;


@Repository
public interface FactureRepository extends MongoRepository<Facture, String>{

	
	//public Facture findBynompatient(String nompatient);
	public Facture findBynommedecin(String nommedecin);
	public Facture findById(int id);
}
