/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

/**
 *
 *
 */

public class Patient implements Serializable {
	   /**
	 * 
	 */
	 @Transient
	 public static final String SEQUENCE_NAME = "patient_sequence";
	 
	private static final long serialVersionUID = 4858964922277461999L;
	/**
	 * 
	 */
	private Collection <User> user=new ArrayList<>();
	private Collection <Consultation>consultation=new ArrayList<>();
	private Collection <Traitement>traitement=new ArrayList<>();
	
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



	public Collection<User> getUser() {
		return user;
	}



	public void setUser(Collection<User> user) {
		this.user = user;
	}

	@Id
	
	    private int id;
	    
	    private String name;
	    
	    private String sexe;
	   
	    private String ville ;
	    private String job;
	    
	   
	    private int age;
	    
	    
	
	    
		public Patient( int id, String name, String sexe, String ville, String job,int age) {
			
			this.id=id;
			this.name=name;
			this.sexe=sexe;
			this.ville=ville;
			this.job=job;
			this.age=age;
		}
		
		
		
		public Patient(String name, String sexe, String ville, String job, int age) {
			super();
			this.name = name;
			this.sexe = sexe;
			this.ville = ville;
			this.job = job;
			this.age = age;
		}



		public Patient() {
			super();
			
		}

		public  int getId() {
			return id;
		}
		public void setId( int id) {
			
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
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getJob() {
			return job;
		}
		public void setJob(String job) {
			this.job = job;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}



		







		
		
}
