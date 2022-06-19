package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Comptable;
import com.example.demo.repository.ComptableRepository;







@Service
public class ComptableService {
	@Autowired
	private ComptableRepository comptableRepository;

	
	//Create operation
	public Comptable createcomp(int id, String name,String sexe, double salaire, Date datedembauche) {
		 
		return comptableRepository.save(new Comptable (id, name, sexe, salaire, datedembauche));
	}
	//Retrieve operation
	public List<Comptable> getAll(){
		return comptableRepository.findAll();
	}
	public Comptable getByName(String name) {
		return comptableRepository.findByName(name);
	}
	//Update operation
	public Comptable update(String name,String sexe, double salaire, Date datedembauche) {
		Comptable cp = comptableRepository.findByName(name);
		cp.setSexe(sexe);
		cp.setSalaire(salaire);
		cp.setDatedembauche(datedembauche);;
		
		return comptableRepository.save(cp);
	}
	//Delete operation
	public void deleteAll() {
		comptableRepository.deleteAll();
	}
	public void delete(int id) {
		Comptable cp = comptableRepository.findById(id);
		comptableRepository.delete(cp);
	}
	
	public Comptable getcomp(int id) {
		return comptableRepository.findById(id);
	}
	
	
	

	  
}
