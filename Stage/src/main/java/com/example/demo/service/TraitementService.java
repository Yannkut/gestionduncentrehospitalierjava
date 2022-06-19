package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Traitement;
import com.example.demo.repository.TraitementRepository;

@Service
	public class TraitementService {
		@Autowired
		private TraitementRepository traitementRepository;
		
		
		
		
		//Create operation
		public Traitement createt(int id, String nomPatient,String nomMedecin,String vaccins, String serums, String analyseschirurgicales, String prescriptionsmedicales, String radios) {
			 
			return traitementRepository.save(new Traitement (id, nomPatient, nomMedecin, vaccins, serums, analyseschirurgicales,prescriptionsmedicales,radios));
		}
		//Retrieve operation
		public List<Traitement> getAll(){
			return traitementRepository.findAll();
		}
		public Traitement getByNomPatient(String nomPatient) {
			return traitementRepository.findByNomPatient(nomPatient);
		}
		//Update operation
		public Traitement updatetr(String nomPatient,String nomMedecin,String vaccins, String serums, String analyseschirurgicales, String prescriptionsmedicales, String radios) {
			Traitement tr = traitementRepository.findByNomPatient(nomPatient);
			tr.setNomPatient(nomPatient);
			tr.setNomMedecin(nomMedecin);
			tr.setVaccins(vaccins);
			tr.setSerums(serums);

			tr.setAnalyseschirurgicales(analyseschirurgicales);
			tr.setPrescriptionsmedicales(prescriptionsmedicales);
			tr.setRadios(radios);
		
			return traitementRepository.save(tr);
		}
		//Delete operation
		public void deleteAll() {
			traitementRepository.deleteAll();
		}
		
		
		public void deletetr(int id) {
			Traitement tr = traitementRepository.findById(id);
			traitementRepository.delete(tr);
		}
		
		public Traitement gettr(int id) {
			return traitementRepository.findById(id);
		}
	}



