package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.configuration.SecurityConfiguration;
import com.example.demo.configuration.UserPrincipal;
import com.example.demo.model.Actionnaire;
import com.example.demo.model.Comptable;
import com.example.demo.model.Médecin;
import com.example.demo.model.Patient;
import com.example.demo.model.Secrétaire;
import com.example.demo.model.User;
import com.example.demo.model.impressions.PDFExporterActionnaire;
import com.example.demo.model.impressions.PDFExporterComptable;
import com.example.demo.model.impressions.PDFExporterMédecin;
import com.example.demo.model.impressions.PDFExporterPatient;
import com.example.demo.model.impressions.PDFExporterSecrétaire;
import com.example.demo.model.impressions.PDFExporterUser;
import com.example.demo.repository.PatientRepository;
import com.example.demo.service.ActionnaireService;
import com.example.demo.service.ComptableService;
import com.example.demo.service.ConsultationService;
import com.example.demo.service.MédecinService;
import com.example.demo.service.PatientService;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SecrétaireService;
import com.example.demo.service.SequenceGeneratorService;
import com.example.demo.service.UserService;
import com.example.demo.service.UsersServiceImpl;
import com.lowagie.text.DocumentException;
import com.mongodb.diagnostics.logging.Logger;





@Controller
@CrossOrigin

public class AdminController {

	
	private static final String roles = null;

	@Autowired
	private UsersServiceImpl usService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private ActionnaireService actionnaireService;
	@Autowired
	private ConsultationService consultationService;
	@Autowired
	private RendezvousService rendezvousService;
	@Autowired
	private ComptableService comptableService;
	@Autowired
	private MédecinService médecinService;
	@Autowired
	private SecrétaireService secrétaireService;
	
	
	
	
	@Autowired
	SecurityConfiguration securityConfiguration;
	@Autowired
	private SequenceGeneratorService sgs;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	
	 public AdminController( PasswordEncoder passwordEncoder) {

	     this.passwordEncoder = passwordEncoder; 
	 }
	
	
	  @GetMapping("/admin")
	    
	    public String admin(){
	        return "Admin/gestionadmin";
	    }
 
 //---------Début Patient//________________
    
	 
	@GetMapping("/gestionpatient")
    public String adminpatient(){
        return "Admin/Patient/gestionpatient";
    }
    //Nouveau Patient
    @RequestMapping(value = "/nouveauPatient" )
	public String nouveauPatient(Model m) {
		Patient patient = new Patient();
		
		//Génération automatique de l'Id
		patient.setId(sgs.getSequenceNumber(Patient.SEQUENCE_NAME));
		m.addAttribute("patient", patient);
		return "Admin/Patient/nouveauPatient";	
    }
    

	@RequestMapping(value = "/create", method = RequestMethod.POST)


	public String createnewPatient(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam String ville,@RequestParam String job, @RequestParam int age ) {
		
		@SuppressWarnings("unused")
		Patient p = patientService.create( id, name, sexe,ville,job,age );
		return "Admin/Patient/gestionpatient";	
		
	}	
	
	 
		@RequestMapping("/getpat")
		public String getPatient(Model m, @RequestParam int id) {
			
			Patient p= patientService.getp(id);
			m.addAttribute("patient", p);
			return "Admin/Patient/update";
			
		}

		
		@RequestMapping(value = "/getAllPatients" )
		
		public String getAllPatients(Model m) {
			List<Patient> listPatients = patientService.getAll();
			m.addAttribute("listPatients", listPatients);
			return "Admin/Patient/listpatients";
			}
		
	
	    
		@RequestMapping(value = "/getPatient", method = RequestMethod.POST)
		public String getPatient2(Model m, @RequestParam int id) {
			
			Patient p= patientService.getp(id);
			
			m.addAttribute("patient", p);
			return "Admin/Patient/nouveauPatient";
			
		}
		  
				//@RequestMapping(value ="/getPatientbyname/{name}", method = RequestMethod.GET )
				//public String getByNamep(  @PathVariable  String name){
				
				//Patient p=patientService.getByName(name) ;
					
						//m.addAttribute("patient", p);
					//return "Admin/Patient/nouveauPatient";
					
					
				//}
				@RequestMapping(value = "/getPatientbyname/{name}", method = RequestMethod.POST)
				public String getPatient2( Model m,@PathVariable  String name) {
					
					Patient p= patientService.getByName(name);
					m.addAttribute("patient", p);
					
					return "Admin/Patient/nouveauPatient";
					
				}
				//@RequestMapping(method=GET, value={"/", "/{id}"})
				//public void get(@PathVariable Optional<Integer> id) {
	       			 // if (id.isPresent()) {
				   // id.get()   //returns the id
				 // }
				//}
			
		
		
	@RequestMapping("/deletepat")
		
		public String delete(@RequestParam int id) {
			
			usService.deletep(id);
			return "Admin/Patient/gestionpatient";
		
			
		}
	@GetMapping("/listpatientbyadminpdf") 
    public void listpatientPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename= La liste des Patients du _" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
       
        List<Patient> listPatients = usService.getAllP();
        
       PDFExporterPatient pfp = new PDFExporterPatient(listPatients);
        pfp.export(response);
       
    }
		 //---------Fin Patient//________________
	
  
		 //---------Début Secrétaire//________________
    @GetMapping("/gestionsecretaire")
    public String adminsecrétaire(){
        return "Admin/Secretaire/gestionsecretaire";
    }
    @RequestMapping(value = "/nouveauSecretaire" )
  	public String nouveauSecretaire(Model m) {
  		Secrétaire secretaire = new Secrétaire();
  		//Génération automatique de l'Id
  		secretaire.setId(sgs.getSequenceNumber(Secrétaire.SEQUENCE_NAME));
  		m.addAttribute("secretaire", secretaire);
  		return "Admin/Secretaire/nouveauSecretaire";
      }

	@RequestMapping(value = "/createsecr", method = RequestMethod.POST)


	public String createnewSecrétaire(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam int salaire) {
		
		@SuppressWarnings("unused")
		Secrétaire  s = secrétaireService.createsecr( id, name, sexe,salaire );
		return "Admin/Secretaire/gestionsecretaire";	
		
	}
	
	
	@RequestMapping("/getsecr")
	public String getSecrétaire(Model m, @RequestParam int id) {
		
		Secrétaire s= secrétaireService.get(id);
		m.addAttribute("secretaire", s);
		return "Admin/Secretaire/updatesecretaire";
		
	}
	@RequestMapping("/getSecretaire")
	public String getSecretaire(Model m, @RequestParam int id) {
		
		Secrétaire s= secrétaireService.get(id);
		m.addAttribute("secretaire", s);
		return "Admin/Secretaire/nouveauSecretaire";
		
	}

	@RequestMapping(value = "/getAllSecretaire" )
	
	public String getAllSecretaire(Model m) {
		List<Secrétaire> listSecretaires = secrétaireService.getAll();
		m.addAttribute("listSecretaires", listSecretaires);
		return "Admin/Secretaire/listSecretaires";
		}
	
	@RequestMapping("/deletesecr")
	
	public String deletesec(@RequestParam int id) {
		
		secrétaireService.delete(id);
		return "Admin/Secretaire/gestionsecretaire";
	}
	  @GetMapping("/listsecretairepdf") 
	    public void listsecretairePDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des Secrétaires du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Secrétaire> listSecrétaires = secrétaireService.getAll();
	        
	       PDFExporterSecrétaire pfrdv = new PDFExporterSecrétaire(listSecrétaires);
	        pfrdv.export(response);
	       
	    }
	
	//---------Fin Secrétaire//________________
	
	
    
	//---------Début  Médecin//________________
    
    @GetMapping("/gestionmedecin")
    public String adminmédecin(){
        return "Admin/Medecin/gestionmedecin";
      }
	

    
    
    @RequestMapping(value = "/nouveauMedecin" )
  	public String nouveauMedecin(Model m) {
  		Médecin medecin = new Médecin();
  		//Génération automatique de l'Id
  		medecin.setId(sgs.getSequenceNumber(Médecin.SEQUENCE_NAME));
  		m.addAttribute("medecin",medecin);
  		return "Admin/Medecin/nouveauMedecin";
  		
      }
    
		
		@RequestMapping(value = "/createm", method = RequestMethod.POST)


		public String createnewMédecin(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam double salaire,@RequestParam Date datedembauche, @RequestParam String speciality ) {
			
			@SuppressWarnings("unused")
			Médecin m = médecinService.createm( id, name, sexe, salaire,datedembauche,speciality );
			return "Admin/Medecin/gestionmedecin";	
			
		}
		@RequestMapping(value = "/getAllMedecins" )

		public String getAllMédecins(Model m) {
			List<Médecin> listMedecins = médecinService.getAll();
			m.addAttribute("listMedecins", listMedecins);
			return "Admin/Medecin/listmedecins";
			}
	@RequestMapping("/deletemed")
		
		public String deletemed(@RequestParam int id) {
			
			médecinService.deletemed(id);
			return "Admin/Medecin/gestionmedecin";
			
			
		}
	
	@RequestMapping("/getmed")
	public String getmed(Model m, @RequestParam int id) {
		
		Médecin me= médecinService.getmed(id);
		m.addAttribute("medecin", me);
		return "Admin/Medecin/updatemedecin";
		
	}
	@RequestMapping("/getMedecin")
	public String getmed9(Model m, @RequestParam int id) {
		
		Médecin me= médecinService.getmed(id);
		m.addAttribute("medecin", me);
		return "Admin/Medecin//nouveauMedecin";
		
	}
	
	  @GetMapping("/listmedecinpdf") 
	    public void listmedecinPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des Médecins du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Médecin> listMédecins = médecinService.getAll();
	        
	       PDFExporterMédecin pfrdv = new PDFExporterMédecin(listMédecins);
	        pfrdv.export(response);
	       
	    }
		//---------Fin  Médecin//________________
		
	
		
//---------Début  Comptable//________________
    
    @GetMapping("/gestioncomptable")
    public String adminComptable(){
        return "Admin/Comptable/gestioncomptable";
    }
	

    
    
    @RequestMapping(value = "/nouveauComptable" )
  	public String nouveauComptable(Model m) {
  		Comptable comptable = new Comptable();
  		//Génération automatique de l'Id
  		comptable.setId(sgs.getSequenceNumber(Comptable.SEQUENCE_NAME));
  		m.addAttribute("comptable",comptable);
  		return "Admin/Comptable/nouveauComptable";
  		
      }
    
		
		@RequestMapping(value = "/createcomp", method = RequestMethod.POST)


		public String createnewComptable(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam double salaire,@RequestParam Date datedembauche ) {
			
			@SuppressWarnings("unused")
			Comptable cp = comptableService.createcomp( id, name, sexe, salaire,datedembauche );
			return "Admin/Comptable/gestioncomptable";	
			
		}
		@RequestMapping(value = "/getAllComptables" )

		public String getAllComptables(Model m) {
			List<Comptable> listComptables = comptableService.getAll();
			m.addAttribute("listcomptables", listComptables);
			return "Admin/Comptable/listcomptables";
			}
	@RequestMapping("/deletecomp")
		
		public String deletecomp(@RequestParam int id) {
			
			comptableService.delete(id);
			return "Admin/Comptable/gestioncomptable";
			
			
		}
	
	@RequestMapping("/getcomp")
	public String getComptable(Model m, @RequestParam int id) {
		
		Comptable cp = comptableService.getcomp(id);
  		m.addAttribute("comptable",cp);
		return "Admin/Comptable/updatecomptable";
		
	} 
	@RequestMapping("/getComptable")
	public String getComptable2(Model m, @RequestParam int id) {
		
		Comptable cp = comptableService.getcomp(id);
  		m.addAttribute("comptable",cp);
		return "Admin/Comptable/nouveauComptable";
		
	}
	 @GetMapping("/listcomptablepdf") 
	    public void listcomptablePDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des Comptables du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Comptable> listComptables = comptableService.getAll();
	        
	       PDFExporterComptable pfrdv = new PDFExporterComptable(listComptables);
	        pfrdv.export(response);
	       
	    }
	//---------Fin Comptable//________________
	
	//---------Début  User//________________

    @GetMapping("/gestionuser")
    public String adminUser(){
        return "Admin/User/gestionuser";
    }
	

    
    
    @RequestMapping(value = "/nouveauUser" )
  	public String nouveauUser(Model m) {
  		User user = new User();
  		//Génération automatique de l'Id
  		user.setId(sgs.getSequenceNumber(User.SEQUENCE_NAME));

  		m.addAttribute("user",user);
  		return "Admin/User/nouveauUser";
  		
      }
	

		
		@RequestMapping(value = "/createuser", method = RequestMethod.POST)


		public String createnewUser(@RequestParam int id, @RequestParam String username,@RequestParam String password,@RequestParam int active,@RequestParam String roles,@RequestParam String permissions ) {
			
			@SuppressWarnings("unused")
			User us = userService.createuser( id, username, passwordEncoder.encode(password),active, roles,permissions );
			return "Admin/User/gestionuser";
			
			
		}
		
		@RequestMapping(value = "/crtuser", method = RequestMethod.POST)


		public String crtUser(@RequestParam int id, @RequestParam String username,@RequestParam String password, @RequestParam int active ,@RequestParam String roles) {
			
			@SuppressWarnings("unused")
			User us = userService.puser(id, username, passwordEncoder.encode(password), active,roles);
			return "Cobra Medical/index";
			
			
		}
		
		
		@RequestMapping("/getAllUsers"   )

		public String getAllUsers(Model m) {
			List<User> listUsers = userService.getAll();
			
			m.addAttribute("listUsers", listUsers);
			return "Admin/User/listusers";
			}
	
		
		
	
	
	@RequestMapping("/deleteuser")
		
		public String deleteuser(@RequestParam int id) {
			
			userService.deleteuser(id);
			return "Admin/User/gestionuser";
			
			
		}
	@RequestMapping ("/getUser")
	public String getUser2(Model m, @RequestParam int id) {
		
		User us = userService.getuser(id);
	
		
		m.addAttribute("user", us);
		return "Admin/User/nouveauUser";
		
	}
	
	//@RequestMapping(value = "/getUserbyroles/{roles}", method = RequestMethod.POST)
	//public String getUserby( @PathVariable  String roles) {
		
		//@SuppressWarnings("unused")
		//User us= userService.getByRole(roles);
		
		
		//return "La liste des clients ayant les roles  :"+roles;
		
	//}

	
	//@RequestMapping(value ="/getUserbyroles",method = RequestMethod.POST)
    //public String show(Model m,@PathVariable String roles) {
    	//List <User> rolADMIN= userService.getByRoles("ADMIN");
    	//m.addAttribute("li", rolADMIN);
        //return "Admin/User/listRoles";
   // }
	
	
	
	@RequestMapping("/getuser")
	public String getUser(Model m, @RequestParam int id) {
		
		User us = userService.getuser(id);
  		m.addAttribute("user",us);
		return "Admin/User/updateuser";
		
	} 

	
	 @GetMapping("/listuserpdf") 
	    public void listuserPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des Utilisateurs" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<User> listUsers = userService.getAll();
	        
	       PDFExporterUser pfrdv = new PDFExporterUser(listUsers);
	        pfrdv.export(response);
	       
	    }
	//---------Fin  User//________________
	
	
	
	//---------Début  Actionnaire//________________

    @GetMapping("/gestionactionnaire")
    public String adminActionnaire(){
        return "Admin/Actionnaires/gestionactionnaire";
    }
	

    
    
    @RequestMapping(value = "/nouveauActionnaire" )
  	public String nouveauActionnaire(Model m) {
  		Actionnaire actionnaire = new Actionnaire();
  		//Génération automatique de l'Id
  		actionnaire.setId(sgs.getSequenceNumber(Actionnaire.SEQUENCE_NAME));
  		m.addAttribute("actionnaire",actionnaire);
  		return "Admin/Actionnaires/nouveauActionnaire";
  		
      }
    
		
    @RequestMapping(value = "/createact", method = RequestMethod.POST)


	public String createnewActionnaire(@RequestParam int id, @RequestParam String name,@RequestParam String sexe,@RequestParam String ville,@RequestParam String job, @RequestParam int age ) {
		
		@SuppressWarnings("unused")
		Actionnaire ac = actionnaireService.createac( id, name, sexe,ville,job,age );
		return "Admin/Actionnaires/gestionactionnaire";	
		
	}	
	
	 
		@RequestMapping("/getact")
		public String getActionnaire(Model m, @RequestParam int id) {
			
			Actionnaire ac= actionnaireService.get(id);
			m.addAttribute("actionnaire", ac);
			return "Admin/Actionnaires/update";
			
		}
		@RequestMapping("/getActionnaire")
		public String getActionnaire9(Model m, @RequestParam int id) {
			
			Actionnaire ac= actionnaireService.get(id);
			m.addAttribute("actionnaire", ac);
			return "Admin/Actionnaires/nouveauActionnaire";
			
		}
		
		
		@RequestMapping(value = "/getAllActionnaires" )
		
		public String getAllActionnaires(Model m) {
			List<Actionnaire> listActionnaires = actionnaireService.getAll();
			m.addAttribute("listActionnaires", listActionnaires);
			return "Admin/Actionnaires/listactionnaires";
			}
		@RequestMapping(value = "/getActionnaire", method = RequestMethod.POST)
		public String getActionnaire2(Model m, @RequestParam int id) {
			
			Actionnaire ac= actionnaireService.get(id);
			
			m.addAttribute("actionnaire", ac);
			return "Admin/Actionnaires/nouveauActionnaire";
			
		}
		
	@RequestMapping("/deleteact")
		
		public String delete3(@RequestParam int id) {
			
			actionnaireService.delete(id);
			return "Admin/Actionnaires/gestionactionnaire";
		
			
		}
	
	   @GetMapping("/listactionnairepdf") 
	    public void listactionnairePDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename= La liste des Actionnaires du _" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	       
	        List<Actionnaire> listActionnaires = actionnaireService.getAll();
	        
	       PDFExporterActionnaire pfrdv = new PDFExporterActionnaire(listActionnaires);
	        pfrdv.export(response);
	       
	    }
	//---------Fin  Actionnaire//________________
	   
	   


	   
}
    
