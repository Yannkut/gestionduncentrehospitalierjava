package com.example.demo.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Actionnaire;


@Repository
	public interface ActionnaireRepository extends MongoRepository<Actionnaire, String> {

	public Actionnaire findByName(String name);
	public List<Actionnaire> findByAge(int age);
	public Actionnaire findById(int id);


	}


