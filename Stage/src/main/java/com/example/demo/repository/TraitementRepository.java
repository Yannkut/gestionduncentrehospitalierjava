package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

import com.example.demo.model.Traitement;



@Repository
public interface TraitementRepository extends MongoRepository<Traitement, String> {
	public Traitement findByNomPatient(String nomPatient);
	public Traitement findById(int id);
	List<Traitement>findByPatient(Patient patient);
	



}
