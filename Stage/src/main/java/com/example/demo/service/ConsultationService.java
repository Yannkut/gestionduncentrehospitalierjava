package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Consultation;
import com.example.demo.repository.ConsultationRepository;



	@Service
	public class ConsultationService {
		@Autowired
		private ConsultationRepository consultationRepository;
		
		
        
	
		
		//Create operation
		public Consultation createcons(int id, int taille,int poids, String allergie, String antecedants, String contresindications, int temperature) {
			 
			return consultationRepository.save(new Consultation (id, taille, poids, allergie, antecedants,contresindications, temperature));
		}
	
		//Retrieve operation
		public List<Consultation> getAll(){
			return consultationRepository.findAll();
		}
		//public Consultation getByAllergie(String allergie) {
		//	return consultationRepository.findByAllergie(allergie);
		//}
		
		//Update operation
		public Consultation updatecons(int taille ,int poids , String allergie, String antecedants, String contresindications, int temperature) {
			Consultation cons = consultationRepository.findByAllergie(allergie);
			cons.setTaille(taille);
			cons.setPoids(poids);
			
			cons.setAntecedants(antecedants);
			cons.setContresindications(contresindications);
			cons.setTemperature(temperature);
			return consultationRepository.save(cons);
		}
		//Delete operation
		public void deleteAll() {
			consultationRepository.deleteAll();
		}
		public void deletecons(int id) {
		Consultation cons = consultationRepository.findById(id);
		consultationRepository.delete(cons);;
		}
		
		public Consultation getcons(int id) {
			return consultationRepository.findById(id);
		}

	
		
}
