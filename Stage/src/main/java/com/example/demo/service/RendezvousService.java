package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Rendezvous;
import com.example.demo.repository.RendezvousRepository;


@Service
public class RendezvousService {
	
	@Autowired
	private RendezvousRepository rendezvousRepository;

	//Create operation
	public Rendezvous createrdv(int id, String Nom, String Prenom, int Age, int NumTelephone,String Speciality,String PlageHoraire, String Message ) {
		 
		return rendezvousRepository.save(new Rendezvous (id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message));
	}
	public Rendezvous pcreaterdv(int id, String Nom, String Prenom, int Age, int NumTelephone,String Speciality,String PlageHoraire, String Message ) {
		 
		return rendezvousRepository.save(new Rendezvous (id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message));
	}
	
	public List<Rendezvous> getAll(){
		return rendezvousRepository.findAll();
	}
	public Rendezvous getByNom(String Nom) {
		return rendezvousRepository.findByNom(Nom);
	}
	public Rendezvous getByPrenom(String Prenom) {
		return rendezvousRepository.findByPrenom(Prenom);
	}
	
	//Update operation
	public Rendezvous update(String Nom, String Prenom, int Age,int NumTelephone, String Speciality,String PlageHoraire,String Message) {
		Rendezvous r = rendezvousRepository.findByNom(Nom);
		r.setNom(Nom);
		r.setPrenom(Prenom);
		r.setAge(Age);
		r.setNumTelephone(NumTelephone);
		r.setSpeciality(Speciality);
		r.setPlageHoraire(PlageHoraire);
		r.setMessage(Message);
	  return rendezvousRepository.save(r);
	}
	//Delete operation
	public void deleteAll() {
		rendezvousRepository.deleteAll();
	}
	public void delete(int id) {
		Rendezvous r = rendezvousRepository.findById(id);
		rendezvousRepository.delete(r);
	}
	
	public Rendezvous get(int id) {
		return rendezvousRepository.findById(id);
	}
	
	
	
}
