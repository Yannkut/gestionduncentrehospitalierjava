package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Médecin;

import com.example.demo.repository.MédecinRepository;

@Service
	public class MédecinService {
		@Autowired
		private MédecinRepository médecinRepository;
		
		
		
		//Create operation
		public Médecin createm(int id, String name,String sexe, double salaire, Date datedembauche, String speciality) {
			 
			return médecinRepository.save(new Médecin (id, name, sexe, salaire,datedembauche,speciality));
		}
		//Retrieve operation
		public List<Médecin> getAll(){
			return médecinRepository.findAll();
		}
		public Médecin getByName(String name) {
			return médecinRepository.findByName(name);
		}
		//Update operation
		public Médecin updatemed(String name,String sexe, double salaire, Date datedembauche, String speciality) {
			Médecin  md = médecinRepository.findByName(name);
			md.setSexe(sexe);
			md.setSalaire(salaire);
			md.setDatedembauche(datedembauche);
			md.setSpeciality(speciality);
			return médecinRepository.save(md);
		}
		//Delete operation
		public void deleteAll() {
			médecinRepository.deleteAll();
		}
		
		
		public void deletemed(int id) {
			Médecin md = médecinRepository.findById(id);
			médecinRepository.delete(md);
		}
		
		public Médecin getmed(int id) {
			return médecinRepository.findById(id);
		}
	}


