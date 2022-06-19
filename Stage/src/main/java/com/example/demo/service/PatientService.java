package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;


@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;
	
	

	
	//Create operation
	public Patient create(int id, String name,String sexe, String ville, String job, int age) {
		 
		return patientRepository.save(new Patient (id, name, sexe, ville,job,age));
	}

	public List<Patient> getAll(){
		return patientRepository.findAll();
	}
	public Patient getByName(String name) {
		return patientRepository.findByName(name);
	}
	
	//Update operation
	public Patient update(String name,String sexe, String ville, String job, int age) {
		Patient p = patientRepository.findByName(name);
		p.setSexe(sexe);
		p.setVille(ville);
		p.setJob(job);
		p.setAge(age);
		return patientRepository.save(p);
	}
	//Delete operation
	public void deleteAllp() {
		patientRepository.deleteAll();
	}
	public void deletep(int id) {
		Patient p = patientRepository.findById(id);
		patientRepository.delete(p);
	}
	

	
	
	public Patient getp(int id) {
		return patientRepository.findById(id);
	}
	
	//Créer une liste de récupération de rendez vous pour le patient
}
