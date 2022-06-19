package com.example.demo.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Contact;

@Repository
	public interface ContactRepository extends MongoRepository<Contact, String> {

	public Contact findByName(String name);
	
	public Contact findById(int id);
	
	


	}

