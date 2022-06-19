package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Hospitalisation;
import com.example.demo.repository.HospitalisationRepository;


@Service
public class HospitalisationService {
	@Autowired
	private HospitalisationRepository hospitalisationRepository;
	
	//Create operation
	public Hospitalisation createhosp(String id, int numSalle, int numLit, String nomPatient) {
		 
		return hospitalisationRepository.save(new Hospitalisation (id, numSalle,numLit,nomPatient));
	}
	//Retrieve operation
	public List<Hospitalisation> getAll(){
		return hospitalisationRepository.findAll();
	}
	public Hospitalisation getBynomPatient(String nomPatient) {
		return hospitalisationRepository.findBynomPatient(nomPatient);
	}
	//Update operation
	public Hospitalisation update(int numSalle, int numLit, String nomPatient) {
		Hospitalisation h = hospitalisationRepository.findBynomPatient(nomPatient);
		h.setNumSalle(numSalle);
		h.setNumLit(numLit);

		return hospitalisationRepository.save(h);
	}
	//Delete operation
	public void deleteAll() {
		hospitalisationRepository.deleteAll();
	}
	public void delete(String id) {
		Hospitalisation h = hospitalisationRepository.findById(id).get();
		hospitalisationRepository.delete(h);
	}
	
	public Hospitalisation get(String id) {
		return hospitalisationRepository.findById(id).get();
	}
}
