package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Facture;
import com.example.demo.repository.FactureRepository;
@Service
public class FactureService {
	private FactureRepository factureRepository;
	//Create operation
		public Facture createfac(int id,int quantite,String designation,String nommedecin, String destfacture,int pu,int pt,String description,  Date date, int tel ,String email) {
			 
			return factureRepository.save(new Facture (id, quantite,designation, nommedecin, destfacture,pu,pt,description,date, tel ,email));
		}
		
		//Retrieve operation
		public List<Facture> getAll(){
			return factureRepository.findAll();
		}
		public Facture getByNomPatient(String nommedecin) {
			return factureRepository.findBynommedecin(nommedecin);
		}
		
		//Update operation
		public Facture update(int quantite,String designation,String nommedecin, String destfacture,int pu,int pt,String description,  Date date, int tel ,String email) {
			Facture fac = factureRepository.findBynommedecin(nommedecin);
			
			fac.setQuantite(quantite);
			fac.setDesignation(designation);
			fac.setDestfacture(destfacture);
			fac.setPu(pu);
			fac.setPt(pt);
			fac.setDescription(description);
			fac.setDate(date);
			fac.setTel(tel);
			fac.setEmail(email);
            return factureRepository.save(fac);
		}
		//Delete operation
		public void deleteAll() {
			factureRepository.deleteAll();
		}
		public void delete(int id) {
			Facture fac = factureRepository.findById(id);
			factureRepository.delete(fac);
		}
		

		
		
		public Facture get(int id) {
			return factureRepository.findById(id);
		}
}
