package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "hospitalisation")

public class Hospitalisation {
 @Transient
public static final String SEQUENCE_NAME = "hospitalisation_sequence";
@Id	
private String id;
private int numSalle;
private int numLit;
private String nomPatient;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public int getNumSalle() {
	return numSalle;
}
public void setNumSalle(int numSalle) {
	this.numSalle = numSalle;
}
public int getNumLit() {
	return numLit;
}
public void setNumLit(int numLit) {
	this.numLit = numLit;
}
public String getNomPatient() {
	return nomPatient;
}
public void setNomPatient(String nomPatient) {
	this.nomPatient = nomPatient;
}
public Hospitalisation() {
	super();
	// TODO Auto-generated constructor stub
}
public Hospitalisation(String id, int numSalle, int numLit, String nomPatient) {
	super();
	this.id = id;
	this.numSalle = numSalle;
	this.numLit = numLit;
	this.nomPatient = nomPatient;
}
public Hospitalisation(int numSalle, int numLit, String nomPatient) {
	super();
	this.numSalle = numSalle;
	this.numLit = numLit;
	this.nomPatient = nomPatient;
}





}

