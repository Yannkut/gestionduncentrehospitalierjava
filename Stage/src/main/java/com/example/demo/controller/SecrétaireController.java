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

import com.example.demo.model.Patient;
import com.example.demo.model.Rendezvous;
import com.example.demo.model.impressions.PDFExporterRendezvous;
import com.example.demo.service.PatientService;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SequenceGeneratorService;
import com.example.demo.service.UserService;
import com.lowagie.text.DocumentException;


	@Controller
	
	public class SecrétaireController {
		@Autowired
		private SequenceGeneratorService sgs;
		
		@Autowired
		private PatientService patientService;
		
		@Autowired
		private RendezvousService rendezvousService;
		@Autowired
		private UserService userService;
		
		
		
		

		
		//--------- Début Secretaire //________________
		@GetMapping("/secretaire")
		 public String secretairepar(){
	        return "Secretaire/gestionp";
	    }
		
		
		
	

		 //---------Début RDV//________________
		@GetMapping("/spgestionRendezvous")
		 public String rendezvous(){
	        return "Secretaire/Rendezvous/spgestionRendezvous";
	    }
		  //Nouveau Rendezvous
	    @RequestMapping(value = "/spaffecterRDV" )
		public String spaffecterRDV(Model m) {
			Rendezvous rdv = new Rendezvous();
			//Génération automatique de l'Id
			rdv.setId(sgs.getSequenceNumber(Rendezvous.SEQUENCE_NAME));
			m.addAttribute("rendezvous", rdv);
			return "Secretaire/Rendezvous/affecterrendezvous";	
	    }
		@RequestMapping(value = "/spcreaterdv", method = RequestMethod.POST)


		public String spaffecterRDV(@RequestParam int id , @RequestParam String Nom, @RequestParam String Prenom, @RequestParam int Age,@RequestParam int NumTelephone, @RequestParam String Speciality,@RequestParam String PlageHoraire, @RequestParam String Message ) {
			
			@SuppressWarnings("unused")
			Rendezvous rdv = rendezvousService.createrdv( id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message);
			return "Secretaire/Rendezvous/spgestionrendezvous";	
			
		}
	    
	    
	  //List Rendezvous
	    @RequestMapping(value = "/spgetAllRDV" )

		public String spgetAllRDV(Model m) {
			List<Rendezvous> listRendezvous = rendezvousService.getAll();
			m.addAttribute("listRendezvous", listRendezvous);
			return "Secretaire/Rendezvous/listRendezvous";
			}
	@RequestMapping("/spdeleterdv")
		
		public String spdeleterdv(@RequestParam int id) {
			
			rendezvousService.delete(id);
			return "Secretaire/Rendezvous/spgestionRendezvous";
			
			
		}
	
	@RequestMapping("/spgetrdv")
	public String spgetrdv(Model m, @RequestParam int id) {
		
		Rendezvous rdv= rendezvousService.get(id);
		m.addAttribute("rendezvous", rdv);
		return "Secretaire/Rendezvous/update";
		
	}

	@RequestMapping("/spgetrdvous")
	public String spgetrdvous(Model m, @RequestParam int id) {
		
		Rendezvous rdv= rendezvousService.get(id);
		m.addAttribute("rendezvous", rdv);
		return "Secretaire/Rendezvous/affecterrendezvous";
		
	}
	
	
	
	
	   @GetMapping("/listrendezvouspdf") 
	    public void listrendezvousToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des rendezvous du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Rendezvous> listRendezvous = rendezvousService.getAll();
	        
	       PDFExporterRendezvous pfrdv = new PDFExporterRendezvous(listRendezvous);
	        pfrdv.export(response);
	       
	    }
	    
		 //---------Fin RDV//________________
		
		 //---------Début Patient//________________
		@GetMapping("/spgestionPatient")
		 public String secreparisgestiontient(){
	        return "Secretaire/Patient/spgestionPatient";
	    }
		  //Nouveau Patient
		
	    @RequestMapping(value = "/spnouveauPatient" )
		public String spnouveauPatient(Model m) {
			Patient patient = new Patient();
			//Génération automatique de l'Id
			patient.setId(sgs.getSequenceNumber(Patient.SEQUENCE_NAME));
			m.addAttribute("patient", patient);
			return "Secretaire/Patient/nouveauPatient";	
	    }
		@RequestMapping(value = "/spcreate", method = RequestMethod.POST)


		public String spcreatenewPatient(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam String ville,@RequestParam String job, @RequestParam int age ) {
			
			@SuppressWarnings("unused")
			Patient p = patientService.create( id, name, sexe,ville,job,age );
			return "Secretaire/Patient/spgestionPatient";	
			
		}
		
		
		
		
		@RequestMapping("/spget")
		public String spgetPatient(Model m, @RequestParam int id) {
			
			Patient p= patientService.getp(id);
			m.addAttribute("patient", p);
			return "Secretaire/Patient/update";
			
		}
		@RequestMapping("/spgetPatient")
		public String spgetPatient9(Model m, @RequestParam int id) {
			
			Patient p= patientService.getp(id);
			m.addAttribute("patient", p);
			return "Secretaire/Patient/nouveauPatient";
			
		}
	
		
		@RequestMapping(value = "/spgetAllPatients" )
		
		public String spgetAllPatients(Model m) {
			List<Patient> listPatients = patientService.getAll();
			m.addAttribute("listPatients", listPatients);
			return "Secretaire/Patient/listpatients";
			}
		@RequestMapping(value = "/spgetPatient", method = RequestMethod.POST)
		public String spgetPatient2(Model m, @RequestParam int id) {
			
			Patient p= patientService.getp(id);
			
			m.addAttribute("patient", p);
			return "Secretaire/Patient/nouveauPatient";
			
		}
		
	@RequestMapping("/spdelete")
		
		public String deletep(@RequestParam int id) {
			
			patientService.deletep(id);
			return "Secretaire/gestionp";
		
			
		}

        
	   @GetMapping("/listpatientpdf") 
	    public void listpatientToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des patients du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Patient> listPatients = patientService.getAll();
	        
	        com.example.demo.model.impressions.PDFExporter pdf = new com.example.demo.model.impressions.PDFExporter(listPatients);
	        pdf.export(response);
	       
	    }
	
	}
	
		 //---------Fin Patient//________________
	
	 //--------- Fin Secretaire Paris//________________
	   
	   
	   
	 
	
	
	
	   
	        
	 
