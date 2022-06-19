package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actionnaire;
import com.example.demo.repository.ActionnaireRepository;


@Service
public class ActionnaireService {
	@Autowired
	private ActionnaireRepository actionnaireRepository;


	

	
	//Create operation
	public Actionnaire createac(int id, String name,String sexe, String ville, String job, int age) {
		 
		return actionnaireRepository.save(new Actionnaire (id, name, sexe, ville,job,age));
	}
	//public Rendezvous createrdv(String id, Date daterdv, String nomMedecin, String nomPatient) {
		 
		//return rendezvousRepository.save(new Rendezvous (id, daterdv,  nomMedecin,nomPatient));
	//}
	//Retrieve operation
	public List<Actionnaire> getAll(){
		return actionnaireRepository.findAll();
	}
	public Actionnaire getByName(String name) {
		return actionnaireRepository.findByName(name);
	}
	
	//Update operation
	public Actionnaire update(String name,String sexe, String ville, String job, int age) {
		Actionnaire ac = actionnaireRepository.findByName(name);
		ac.setSexe(sexe);
		ac.setVille(ville);
		ac.setJob(job);
		ac.setAge(age);
		return actionnaireRepository.save(ac);
	}
	//Delete operation
	public void deleteAll() {
		actionnaireRepository.deleteAll();
	}
	public void delete(int id) {
		Actionnaire ac = actionnaireRepository.findById(id);
		actionnaireRepository.delete(ac);
	}
	

	
	
	public Actionnaire get(int id) {
		return actionnaireRepository.findById(id);
	}
	
}

