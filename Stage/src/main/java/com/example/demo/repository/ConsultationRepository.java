package com.example.demo.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Consultation;
import com.example.demo.model.Patient;





@Repository

public interface ConsultationRepository extends MongoRepository<Consultation, String>{
	public Consultation findByAllergie(String allergie);
	public Consultation findById(int id);
	
	List<Consultation>findByPatient(Patient patient);
}
