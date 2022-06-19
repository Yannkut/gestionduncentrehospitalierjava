package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;
import com.example.demo.model.Rendezvous;



@Repository
public interface RendezvousRepository extends MongoRepository<Rendezvous, String> {
	public Rendezvous findByNom(String Nom);
	public Rendezvous findByPrenom(String Prenom);
	public Rendezvous findById(int id);
    List<Rendezvous>findByPatient(Patient patient);

	



}
