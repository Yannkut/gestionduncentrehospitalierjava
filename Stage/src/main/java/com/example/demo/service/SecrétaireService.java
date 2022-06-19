package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Secrétaire;
import com.example.demo.model.User;
import com.example.demo.repository.SecrétaireRepository;
import com.example.demo.repository.UserRepository;








@Service
public class SecrétaireService {
	@Autowired
	private SecrétaireRepository secrétaireRepository;
	@Autowired
	private UserRepository userRepository;

	

	//Create operation
	public Secrétaire createsecr(int id, String name,String sexe, int salaire) {
		 
		return secrétaireRepository.save(new Secrétaire (id, name, sexe, salaire));
	}
	
	
	//Create operation
	public Secrétaire createsecrbr(int id, String name,String sexe, int salaire,User user) {
		 
		return secrétaireRepository.save(new Secrétaire (id, name, sexe, salaire));
	}
	//Retrieve operation
	public List<Secrétaire> getAll(){
		return secrétaireRepository.findAll();
	}
	public Secrétaire getByName(String name) {
		return secrétaireRepository.findByName(name);
	}
	//Update operation
	public Secrétaire update(String name,String sexe, int salaire) {
		Secrétaire s = secrétaireRepository.findByName(name);
		s.setSexe(sexe);
		s.setSalaire(salaire);

		return secrétaireRepository.save(s);
	}
	//Delete operation
	public void deleteAll() {
		secrétaireRepository.deleteAll();
	}
	public void delete(int id) {
		Secrétaire s = secrétaireRepository.findById(id);
		secrétaireRepository.delete(s);
	}
	
	public Secrétaire get(int id) {
		return secrétaireRepository.findById(id);
	}
}
