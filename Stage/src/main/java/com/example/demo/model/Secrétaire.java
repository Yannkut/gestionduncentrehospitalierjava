package com.example.demo.model;

import java.io.Serializable;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;


public class Secrétaire implements Serializable {

	  /**
	 * 
	 */
	 @Transient
	    public static final String SEQUENCE_NAME = "secretaire_sequence";
	private static final long serialVersionUID = 1L;
	
	@Id
	    private int id;
	    private String name;
	    private String sexe; 
	    private int salaire;
	
	    
	    
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

		public int getSalaire() {
			return salaire;
		}

		public void setSalaire(int salaire) {
			this.salaire = salaire;
		}

		public Secrétaire() {
			super();
			
		}
	
		public Secrétaire(int id, String name, String sexe, int salaire) {
			super();
			this.id = id;
			this.name = name;
			this.sexe = sexe;
			this.salaire = salaire;
		}
		public Secrétaire(String name, String sexe, int salaire) {
			super();
			this.name = name;
			this.sexe = sexe;
			this.salaire = salaire;
		}
	
		

}
