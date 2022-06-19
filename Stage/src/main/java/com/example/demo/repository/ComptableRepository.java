package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Comptable;


public interface ComptableRepository extends MongoRepository<Comptable, String>{
	public Comptable findByName(String name);
	public Comptable findById(int id);
}
