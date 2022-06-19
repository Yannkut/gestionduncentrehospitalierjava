package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Secrétaire;


public interface SecrétaireRepository extends MongoRepository<Secrétaire, String>{
	public Secrétaire findByName(String name);
	public Secrétaire findById(int id);
	
}
