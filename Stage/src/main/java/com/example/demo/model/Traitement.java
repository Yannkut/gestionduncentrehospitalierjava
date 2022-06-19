package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "traitement")
 public class Traitement {
 @Transient
 public static final String SEQUENCE_NAME = "traitement_sequence";
 
 
 
 private Collection <Patient> patient=new ArrayList<>();

public Collection<Patient> getPatient() {
	return patient;
}
public void setPatient(Collection<Patient> patient) {
	this.patient = patient;
}
@Id	
private int id;
private String nomPatient;
private String nomMedecin;
private String vaccins;
private String serums;
private String analyseschirurgicales;
private String prescriptionsmedicales;
private String radios;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNomPatient() {
	return nomPatient;
}
public void setNomPatient(String nomPatient) {
	this.nomPatient = nomPatient;
}
public String getNomMedecin() {
	return nomMedecin;
}
public void setNomMedecin(String nomMedecin) {
	this.nomMedecin = nomMedecin;
}
public String getVaccins() {
	return vaccins;
}
public void setVaccins(String vaccins) {
	this.vaccins = vaccins;
}
public String getSerums() {
	return serums;
}
public void setSerums(String serums) {
	this.serums = serums;
}
public String getAnalyseschirurgicales() {
	return analyseschirurgicales;
}
public void setAnalyseschirurgicales(String analyseschirurgicales) {
	this.analyseschirurgicales = analyseschirurgicales;
}
public String getPrescriptionsmedicales() {
	return prescriptionsmedicales;
}
public void setPrescriptionsmedicales(String prescriptionsmedicales) {
	this.prescriptionsmedicales = prescriptionsmedicales;
}
public String getRadios() {
	return radios;
}
public void setRadios(String radios) {
	this.radios = radios;
}
public Traitement() {
	super();
	// TODO Auto-generated constructor stub
}
public Traitement(int id, String nomPatient, String nomMedecin, String vaccins, String serums,
		String analyseschirurgicales, String prescriptionsmedicales, String radios) {
	super();
	this.id = id;
	this.nomPatient = nomPatient;
	this.nomMedecin = nomMedecin;
	this.vaccins = vaccins;
	this.serums = serums;
	this.analyseschirurgicales = analyseschirurgicales;
	this.prescriptionsmedicales = prescriptionsmedicales;
	this.radios = radios;
}
public Traitement(String nomPatient, String nomMedecin, String vaccins, String serums, String analyseschirurgicales,
		String prescriptionsmedicales, String radios) {
	super();
	this.nomPatient = nomPatient;
	this.nomMedecin = nomMedecin;
	this.vaccins = vaccins;
	this.serums = serums;
	this.analyseschirurgicales = analyseschirurgicales;
	this.prescriptionsmedicales = prescriptionsmedicales;
	this.radios = radios;
}
@Override
public String toString() {
	return "Traitement [id=" + id + ", nomPatient=" + nomPatient + ", nomMedecin=" + nomMedecin + ", vaccins=" + vaccins
			+ ", serums=" + serums + ", analyseschirurgicales=" + analyseschirurgicales + ", prescriptionsmédicales="
			+ prescriptionsmedicales + ", radios=" + radios + "]";
}


}
