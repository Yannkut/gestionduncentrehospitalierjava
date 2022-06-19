/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.demo.model;



import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


public class Consultation{
	@Transient
    public static final String SEQUENCE_NAME = "consulatation_sequence";
	private Collection <Patient> patient=new ArrayList<>();

	
	public Collection<Patient> getPatient() {
		return patient;
	}
	public void setPatient(Collection<Patient> patient) {
		this.patient = patient;
	}
	
	@Id
	private int id;
	private int taille;
    private int poids;
    private String allergie;
    private String antecedants;
    private String contresindications;
    private int temperature;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getPoids() {
		return poids;
	}
	public void setPoids(int poids) {
		this.poids = poids;
	}
	public String getAllergie() {
		return allergie;
	}
	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	public String getAntecedants() {
		return antecedants;
	}
	public void setAntecedants(String antecedants) {
		this.antecedants = antecedants;
	}
	public String getContresindications() {
		return contresindications;
	}
	public void setContresindications(String contresindications) {
		this.contresindications = contresindications;
	}

	
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public Consultation(int id, int taille, int poids, String allergie, String antecedants,
			String contresindications, int  temperature) {
		super();
		this.id = id;
		this.taille = taille;
		this.poids = poids;
		this.allergie = allergie;
		this.antecedants = antecedants;
		this.contresindications = contresindications;
		this.temperature = temperature;
	}
	public Consultation(int taille, int poids, String allergie, String antecedants, String contresindications,
			int temperature) {
		super();
		this.taille = taille;
		this.poids = poids;
		this.allergie = allergie;
		this.antecedants = antecedants;
		this.contresindications = contresindications;
		this.temperature = temperature;
	}
	public Consultation() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Consultation [id=" + id + ", taille=" + taille + ", poids=" + poids + ", allergie=" + allergie
				+ ", antecedants=" + antecedants + ", contresindications=" + contresindications + ", temperature="
				+temperature + "]";
	}

	
  
  
    



	
    
    

   
}
