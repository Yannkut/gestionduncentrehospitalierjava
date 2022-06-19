package com.example.demo.model;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;



public class Rendezvous implements Serializable{
/**
	 * 
	 */
	
@Transient
public static final String SEQUENCE_NAME = "rendezvous_sequence";

private static final long serialVersionUID = 1L;


private Médecin medecin;

private Patient patient;
private User user;
private Consultation consulatation;
@Id	
private int id;
private String Nom;
private String Prenom;
private int Age;
private int NumTelephone;
private String Speciality;
private String PlageHoraire;
private String Message;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public int getNumTelephone() {
	return NumTelephone;
}
public void setNumTelephone(int numTelephone) {
	NumTelephone = numTelephone;
}
public String getSpeciality() {
	return Speciality;
}
public void setSpeciality(String speciality) {
	Speciality = speciality;
}
public String getPlageHoraire() {
	return PlageHoraire;
}
public void setPlageHoraire(String plageHoraire) {
	PlageHoraire = plageHoraire;
}
public String getMessage() {
	return Message;
}
public void setMessage(String message) {
	Message = message;
}
public Rendezvous(int id, String nom, String prenom, int age, int numTelephone, String speciality,
		String plageHoraire, String message) {
	super();
	this.id = id;
	Nom = nom;
	Prenom = prenom;
	Age = age;
	NumTelephone = numTelephone;
	Speciality = speciality;
	PlageHoraire = plageHoraire;
	Message = message;
}
public Rendezvous(String nom, String prenom, int age, int numTelephone, String speciality, String plageHoraire,
		String message) {
	super();
	Nom = nom;
	Prenom = prenom;
	Age = age;
	NumTelephone = numTelephone;
	Speciality = speciality;
	PlageHoraire = plageHoraire;
	Message = message;
}
public Rendezvous() {
	super();
	// TODO Auto-generated constructor stub
}
public Rendezvous(String nom, String prenom) {
	super();
	Nom = nom;
	Prenom = prenom;
}











}
