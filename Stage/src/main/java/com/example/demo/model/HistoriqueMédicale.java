package com.example.demo.model;





import com.fasterxml.jackson.annotation.JsonIgnore;

public class HistoriqueMédicale {
	

	private String maladies;
	private String allergies;
	private String medicinegenerale;
	private String groupage;
	private String pressionarterielle;
	private String handicap;
	

	private User user;
	
	
	private Médecin medecin;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Médecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Médecin medecin) {
		this.medecin = medecin;
	}
	public String getMaladies() {
		return maladies;
	}
	public void setMaladies(String maladies) {
		this.maladies = maladies;
	}
	public String getAllergies() {
		return allergies;
	}
	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}
	public String getMedicinegenerale() {
		return medicinegenerale;
	}
	public void setMedicinegenerale(String medicinegenerale) {
		this.medicinegenerale = medicinegenerale;
	}
	public String getGroupage() {
		return groupage;
	}
	public void setGroupage(String groupage) {
		this.groupage = groupage;
	}
	public String getPressionarterielle() {
		return pressionarterielle;
	}
	public void setPressionarterielle(String pressionarterielle) {
		this.pressionarterielle = pressionarterielle;
	}
	public String getHandicap() {
		return handicap;
	}
	public void setHandicap(String handicap) {
		this.handicap = handicap;
	}
	public HistoriqueMédicale() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HistoriqueMédicale(String maladies, String allergies, String medicinegenerale, String groupage,
			String pressionarterielle, String handicap) {
		super();
		this.maladies = maladies;
		this.allergies = allergies;
		this.medicinegenerale = medicinegenerale;
		this.groupage = groupage;
		this.pressionarterielle = pressionarterielle;
		this.handicap = handicap;
	}
	


}