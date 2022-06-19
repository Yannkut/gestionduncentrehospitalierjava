package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 *
 */

public class Comptable implements Serializable {
	 /**
	 * 
	 */
	 @Transient
	    public static final String SEQUENCE_NAME = "comptable_sequence";
	private static final long serialVersionUID = 8891833997223887835L;
	
	private Collection <User> user=new ArrayList<>();
	private Collection <Consultation>consultation=new ArrayList<>();
	private Collection <Traitement>traitement=new ArrayList<>();
	
	
	
	
	
	public Collection<User> getUser() {
		return user;
	}
	public void setUser(Collection<User> user) {
		this.user = user;
	}
	public Collection<Consultation> getConsultation() {
		return consultation;
	}
	public void setConsultation(Collection<Consultation> consultation) {
		this.consultation = consultation;
	}
	public Collection<Traitement> getTraitement() {
		return traitement;
	}
	public void setTraitement(Collection<Traitement> traitement) {
		this.traitement = traitement;
	}

	@Id
	private int id;
	    private String name;
	    private String sexe; 
	    private double salaire;
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    private Date datedembauche;
	
		public Comptable() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSexe() {
			return sexe;
		}
		public void setSexe(String sexe) {
			this.sexe = sexe;
		}
		public double getSalaire() {
			return salaire;
		}
		public void setSalaire(double salaire) {
			this.salaire = salaire;
		}
		public Comptable(int id, String name, String sexe, double salaire, Date datedembauche) {
			super();
			this.id = id;
			this.name = name;
			this.sexe = sexe;
			this.salaire = salaire;
			this.datedembauche = datedembauche;
		}
		public Date getDatedembauche() {
			return datedembauche;
		}
		public void setDatedembauche(Date datedembauche) {
			this.datedembauche = datedembauche;
		}
	    
		public Comptable(String name, String sexe, double salaire, Date datedembauche) {
			super();
			this.name = name;
			this.sexe = sexe;
			this.salaire = salaire;
			this.datedembauche = datedembauche;
		}
}