package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.configuration.SecurityConfiguration;
import com.example.demo.model.Consultation;
import com.example.demo.model.Rendezvous;
import com.example.demo.model.Traitement;
import com.example.demo.model.impressions.PDFExporterRendezvous;
import com.example.demo.service.ConsultationService;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SequenceGeneratorService;
import com.example.demo.service.TraitementService;
import com.lowagie.text.DocumentException;

@Controller

public class MédecinController {
	@Autowired
	private SequenceGeneratorService sgs;
	
	@Autowired
	private TraitementService traitementService;
	
	@Autowired
	private RendezvousService rendezvousService;
	
	@Autowired
	private ConsultationService consultationService;

	@Autowired
	SecurityConfiguration securityConfiguration;
	

	
	@GetMapping("/medecin")
	 public String medecinparis(){
       return "Médecin/gestionmedecin";
   }
	@GetMapping("/mpgestionDM")
	 public String medecinparisdm(){
      return "Médecin/suiviedupatient";
  }
	@GetMapping("/mpgestionRDV")
	 public String medecinparisrdv(){
     return "Médecin/suiviedurendezvous";
 }
	
	@GetMapping("/mpConsultation")
	 public String mpConsultation(){
     return "Médecin/SuivieduPatient/Consultation";
 }
	@GetMapping("/mpOrdonnance")
	 public String mpmedecinparisdm(){
     return "Médecin/SuivieduPatient/Ordonnance";
 }
	@GetMapping("/mpTraitement")
	 public String mpTraitement(){
     return "Médecin/SuivieduPatient/Traitement";
 }
	
	
	//---------Gestion  RDV//________________
	@RequestMapping(value = "/mpnRDV" )
	public String nRendezvous(Model m) {
		Rendezvous rdv = new Rendezvous();
		//Génération automatique de l'Id
		rdv.setId(sgs.getSequenceNumber(Rendezvous.SEQUENCE_NAME));
		m.addAttribute("rendezvous", rdv);
		return "Médecin/Rendezvous/NRendezvous";	
 }
	@RequestMapping(value = "/mdpcreaterdv", method = RequestMethod.POST)


	public String mdpaffecterRDV(@RequestParam int id , @RequestParam String Nom, @RequestParam String Prenom, @RequestParam int Age,@RequestParam int NumTelephone, @RequestParam String Speciality,@RequestParam String PlageHoraire, @RequestParam String Message ) {
		
		@SuppressWarnings("unused")
		Rendezvous rdv = rendezvousService.createrdv( id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message);
		return "Médecin/suiviedurendezvous";	
		
	}
	@RequestMapping(value = "/mpRDV" )

	public String spgetAllRDV(Model m) {
		List<Rendezvous> listRendezvous = rendezvousService.getAll();
		m.addAttribute("listRendezvous", listRendezvous);
		return "Médecin/Rendezvous/listrdv";
		}


@RequestMapping("/mpgetrdv")
public String mpgetrdv(Model m, @RequestParam int id) {
	
	Rendezvous rdv= rendezvousService.get(id);
	m.addAttribute("rendezvous", rdv);
	return "Médecin/Rendezvous/updaterdv";
	
}
@RequestMapping("/mpGetRDV")
public String mpgetrdv9(Model m, @RequestParam int id) {
	
	Rendezvous rdv= rendezvousService.get(id);
	m.addAttribute("rendezvous", rdv);
	return "Médecin/Rendezvous/NRendezvous";
	
}
@RequestMapping("/mdpdeleterdv")

public String spdeleterdv(@RequestParam int id) {
	
	rendezvousService.delete(id);
	return "Médecin/Rendezvous/suiviedurendezvous";
	
	
}
@GetMapping("/listrdvmpdf") 
public void listrdvmPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
    
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename= La liste des rendezvous du _" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
   
    List<Rendezvous> listRendezvous = rendezvousService.getAll();
    
   PDFExporterRendezvous pfrdvm = new PDFExporterRendezvous(listRendezvous);
    pfrdvm.export(response);
   
}
//---------Gestion  Consultation//________________
@RequestMapping(value = "/NouvelleConsultation" )
	public String nouvelleConsultation(Model m) {
		Consultation consultation = new Consultation();
		//Génération automatique de l'Id
		consultation.setId(sgs.getSequenceNumber(Consultation.SEQUENCE_NAME));
		m.addAttribute("consultation", consultation);
		return "Médecin/SuivieduPatient/NouvelleConsultation";	
 }
@RequestMapping(value = "/mpacreate", method = RequestMethod.POST)


public String mpnouvelleConsultation(@RequestParam  int id,
		@RequestParam int taille, @RequestParam int poids, @RequestParam String allergie, @RequestParam String antecedants, @RequestParam String contresindications,
		@RequestParam int temperature) {
	
	@SuppressWarnings("unused")
	Consultation cons = consultationService.createcons( id, taille, poids ,allergie,antecedants,contresindications, temperature );
	return "Médecin/SuivieduPatient/Consultation";	
	
}
@RequestMapping(value = "/ListeConsultations" )

public String mpgetAllConsultation(Model m) {
	List<Consultation>listConsultations = consultationService.getAll();
	m.addAttribute("listConsultations", listConsultations);
	return "Médecin/SuivieduPatient/listConsultations";
	}
@RequestMapping("/mpdeletecons")

public String mpdeletecons(@RequestParam int id) {
	
	consultationService.deletecons(id);
	return "Médecin/SuivieduPatient/Consultation";
	
	
}
@RequestMapping( value ="/mpgetcons")
public String mpgetcons7(Model m, @RequestParam int id) {
	
	Consultation consultation= consultationService.getcons(id);
	m.addAttribute("consultation", consultation);
	return "Médecin/SuivieduPatient/updatecons";
	
}
@RequestMapping( value ="/mpgetconsul")
public String mpgetcons8(Model m, @RequestParam int id) {
	
	Consultation consultation= consultationService.getcons(id);
	m.addAttribute("consultation", consultation);
	return "Médecin/SuivieduPatient/NouvelleConsultation";
	
}
@GetMapping("/listconsultationpdf") 
public void listconsultationToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
    
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename= La liste des consultations du _" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
   
    List<Consultation> listConsultations = consultationService.getAll();
    
    com.example.demo.model.impressions.PDFExporterConsultation pdfcons = new com.example.demo.model.impressions.PDFExporterConsultation(listConsultations);
    pdfcons.export(response);
   
}

//---------Gestion  Traitement//________________	
@RequestMapping(value = "/mpnouveauTraitement" )
public String nouveauTraitement(Model m) {
	Traitement traitement = new Traitement();
	//Génération automatique de l'Id
	traitement.setId(sgs.getSequenceNumber(Traitement.SEQUENCE_NAME));
	m.addAttribute("traitement", traitement);
	return "Médecin/SuivieduPatient/nouveauTraitement";	
}
@RequestMapping(value = "/mpcreatetr", method = RequestMethod.POST)


public String mpnouveauTraitement(@RequestParam int id, @RequestParam String nomPatient, @RequestParam String nomMedecin, @RequestParam String vaccins, @RequestParam String serums, @RequestParam String analyseschirurgicales, @RequestParam String prescriptionsmedicales, @RequestParam String radios) {
	
	@SuppressWarnings("unused")
	Traitement traitement = traitementService.createt( id, nomPatient, nomMedecin, vaccins, serums, analyseschirurgicales,prescriptionsmedicales,radios );
	return "Médecin/SuivieduPatient/Traitement";	
	
}
@RequestMapping(value = "/ListeTraitements" )

public String mpgetAllTraitements(Model m) {
	List<Traitement>listTraitements = traitementService.getAll();
	m.addAttribute("listTraitements", listTraitements);
	return "Médecin/SuivieduPatient/listTraitements";
	}
@RequestMapping("/mpdeletetrait")

public String mpdeletetrait(@RequestParam int id) {
	
	traitementService.deletetr(id);
	return "Médecin/SuivieduPatient/Traitement";
	
	
}
@RequestMapping( value ="/mpgettraitement")
public String mpgettraitement(Model m, @RequestParam int id) {
	
	Traitement traitement= traitementService.gettr(id);
	m.addAttribute("traitement", traitement);
	return "Médecin/SuivieduPatient/updatetrait";
	
}
@RequestMapping( value ="/mpgettrait")
public String mpgettraitement2(Model m, @RequestParam int id) {
	
	Traitement traitement= traitementService.gettr(id);
	m.addAttribute("traitement", traitement);
	return "Médecin/SuivieduPatient/nouveauTraitement";
	
}
@GetMapping("/listtraitementpdf") 
public void listtraitementToPDF(HttpServletResponse response) throws DocumentException, IOException {
    response.setContentType("application/pdf");
    DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
    String currentDateTime = dateFormatter.format(new Date());
    
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename= La liste des traitements du _" + currentDateTime + ".pdf";
    response.setHeader(headerKey, headerValue);
   
    List<Traitement> listTraitements = traitementService.getAll();
    
    com.example.demo.model.impressions.PDFExporterTraitement pdftr = new com.example.demo.model.impressions.PDFExporterTraitement(listTraitements);
    pdftr.export(response);
   
}

}





