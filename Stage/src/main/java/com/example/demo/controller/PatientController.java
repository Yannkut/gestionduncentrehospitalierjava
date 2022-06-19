package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.configuration.UserPrincipal;
import com.example.demo.model.Rendezvous;
import com.example.demo.model.User;
import com.example.demo.repository.RendezvousRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SequenceGeneratorService;
import com.example.demo.service.UserService;


@Controller

public class PatientController {
	
	@Autowired
	private SequenceGeneratorService sgs;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RendezvousService rendezvousService;

	
	
	@GetMapping("/patient")
	    public String patient(){
	        return "Patient/gestionnairepatient";
	    }

	//---------Début  Rendezvous//________________
	
	//Rendez vous dans espace Patient
    @RequestMapping(value = "/rdvpatient" )
		public String rendezvousRDVPAtient(Model m) {
			Rendezvous rdv = new Rendezvous();
			//Génération automatique de l'Id
			rdv.setId(sgs.getSequenceNumber(Rendezvous.SEQUENCE_NAME));
			m.addAttribute("rendezvous", rdv);
			
			return "Patient/rendezvous";	
	    }
  //Prendre un rendezvous sur la Page d'acceuil
    @RequestMapping(value = "/rdvpatientpagedacceuil" )
  		public String rendezvousRDVPAtientpageacceuil(Model m) {
  			Rendezvous rdv = new Rendezvous();
  			//Génération automatique de l'Id
  			rdv.setId(sgs.getSequenceNumber(Rendezvous.SEQUENCE_NAME));
  			m.addAttribute("rendezvous", rdv);
  			
  			return "Patient/index";	
  	    }
	@RequestMapping(value = "/pcreaterdv2", method = RequestMethod.POST)


	public String rendezvousRDVPAtientpageacceuil(@RequestParam int id , @RequestParam String Nom, @RequestParam String Prenom, @RequestParam int Age,@RequestParam int NumTelephone, @RequestParam String Speciality,@RequestParam String PlageHoraire, @RequestParam String Message ) {
		
		@SuppressWarnings("unused")
		Rendezvous rdv = rendezvousService.pcreaterdv( id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message );
		return "Cobra Medical/index";	
		
	}
	 
	@RequestMapping(value = "/pcreaterdv", method = RequestMethod.POST)


	public String rendezvousRDV3(@RequestParam int id , @RequestParam String Nom, @RequestParam String Prenom, @RequestParam int Age,@RequestParam int NumTelephone, @RequestParam String Speciality,@RequestParam String PlageHoraire, @RequestParam String Message ) {
		
		@SuppressWarnings("unused")
		Rendezvous rdv = rendezvousService.pcreaterdv( id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message );
		return "Patient/gestionnairepatient";	
		
	}
	@RequestMapping("/pgetrdv")
	public String spgetrdv(Model m, @RequestParam int id) {
		
		Rendezvous rdv= rendezvousService.get(id);
	
		m.addAttribute("rendezvous", rdv);
		
		return "Patient/rendezvous";
		
	}
	
	@RequestMapping("/pgetrdv2")
	public String spgetrdv2(Model m, @RequestParam String Prenom) {
		
	
		Rendezvous rdv3= rendezvousService.getByPrenom(Prenom);
		m.addAttribute("rendezvous", rdv3);
		
		return "Patient/rendezvous";
		
	}
	@RequestMapping("/pdeleterdv")
	
	public String spdeleterdv(@RequestParam int id) {
		
		rendezvousService.delete(id);
		return "Patient/gestionnairepatient";
		
		
	}
	

		//Update operation
		public User update(String username,String password, int active,String roles, String permissions) {
			User us = userRepository.findByUsername(username);
			us.setUsername(username);
			us.setPassword(password);
			
		
			
			return userRepository.save(us);
		}
		
		@RequestMapping("/pgetuser")
		public String getUser(Model m, @RequestParam int id) {
			
			User us = userService.getuser(id);
	  		m.addAttribute("user",us);
			return "Patient/updateuser";
			
		} 
		
	
		//---------Fin  Rendezvous//________________	
	 
		
		//---------Début Modifiez les informations du patient//________________
		@RequestMapping(value = "/signup" )
	  	public String nwUser(Model m) {
	  		User user = new User();
	  		//Génération automatique de l'Id
	  		user.setId(sgs.getSequenceNumber(User.SEQUENCE_NAME));
	  		user.setRoles("PATIENT");
	  	    user.setActive(1);

	  		m.addAttribute("user",user);
	  		return "Cobra Medical/signup";
	  		
	      }
		@RequestMapping ("/patientgetuser")
		public String pgetUser(Model m, @RequestParam int id) {
			
			User us = userService.getuser(id);
			
			m.addAttribute("user", us);
			return "Patient/updateuser";
			
		}
	
		
		@RequestMapping("/infpatients")
		public String ViewPatient(Model m, @AuthenticationPrincipal UserPrincipal up ) {
			String username=up.getUsername();
			
			User us= userService.getUsername(username);
			
			m.addAttribute("user",us);
			
			
			return "Patient/informationspatient";
		}
		

		//---------FinModifiez les informations du patient//________________
		
}
