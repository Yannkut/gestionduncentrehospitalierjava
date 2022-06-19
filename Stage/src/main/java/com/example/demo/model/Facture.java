package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document(collection = "facture")
public class Facture {
	
	 @Transient
	 public static final String SEQUENCE_NAME = "facture_sequence";

	 @Id
	 private int id;
	 private int quantite;
	 private String designation;
	 private String nommedecin;
	 private String destfacture;
	 
	 private int pu;
	 private int pt;
	 private String description;
	 @DateTimeFormat(pattern = "dd/MM/yyyy")
	 private Date date;
	 private int tel;
	 private String email;
	 
	public int getTel() {
		return tel;
	}
	


	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
	public int getQuantite() {
		return quantite;
	}



	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public String getNommedecin() {
		return nommedecin;
	}
	public void setNommedecin(String nommedecin) {
		this.nommedecin = nommedecin;
	}
	public String getDestfacture() {
		return destfacture;
	}
	public void setDestfacture(String destfacture) {
		this.destfacture = destfacture;
	}
	public int getPu() {
		return pu;
	}
	public void setPu(int pu) {
		this.pu = pu;
	}
	public int getPt() {
		return pt;
	}
	public void setPt(int pt) {
		this.pt = pt;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}



	public Facture(int id, int quantite, String designation, String nommedecin, String destfacture, int pu, int pt,
			String description, Date date, int tel, String email) {  
		super();
		this.id = id;
		this.quantite = quantite;
		this.designation = designation;
		this.nommedecin = nommedecin;
		this.destfacture = destfacture;
		this.pu = pu;
		this.pt = pt;
		this.description = description;
		this.date = date;
		this.tel = tel;
		this.email = email;
	}



	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Facture(int quantite, String designation, String nommedecin, String destfacture, int pu, int pt,
			String description, Date date, int tel, String email) {
		super();
		this.quantite = quantite;
		this.designation = designation;
		this.nommedecin = nommedecin;
		this.destfacture = destfacture;
		this.pu = pu;
		this.pt = pt;
		this.description = description;
		this.date = date;
		this.tel = tel;
		this.email = email;
	}



	@Override
	public String toString() {
		return "Facture [id=" + id + ", quantite=" + quantite + ", designation=" + designation + ", nommedecin="
				+ nommedecin + ", destfacture=" + destfacture + ", pu=" + pu + ", pt=" + pt + ", description="
				+ description + ", date=" + date + ", tel=" + tel + ", email=" + email + "]";
	}
	
	
	
	
	 
	 
	 
}
