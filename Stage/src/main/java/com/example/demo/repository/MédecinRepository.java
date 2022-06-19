package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Médecin;
@Repository
public interface MédecinRepository extends MongoRepository<Médecin, String>{
	public Médecin findByName(String name);
	public Médecin findById(int id);
}
