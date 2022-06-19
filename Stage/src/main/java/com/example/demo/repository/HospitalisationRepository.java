
package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Hospitalisation;


public interface HospitalisationRepository extends MongoRepository<Hospitalisation, String>{
	public Hospitalisation findBynomPatient(String nomPatient);
}