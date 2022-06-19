package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Rendezvous;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SequenceGeneratorService;

@Controller
public class RendezvousController {
	@Autowired
	private RendezvousService rendezvousService;
	
	@Autowired
	private SequenceGeneratorService sgs;
	
    @RequestMapping(value = "/newRDV" )
		public String rendezvousRDV(Model m) {
			Rendezvous rdv = new Rendezvous();
			//Génération automatique de l'Id
			rdv.setId(sgs.getSequenceNumber(Rendezvous.SEQUENCE_NAME));
			m.addAttribute("rendezvous", rdv);
			
			return "Rendezvous/rendezvous";	
	    }
		@RequestMapping(value = "/createrdv", method = RequestMethod.POST)


		public String rendezvousRDV2(@RequestParam int id , @RequestParam String Nom, @RequestParam String Prenom, @RequestParam int Age,@RequestParam int NumTelephone, @RequestParam String Speciality,@RequestParam String PlageHoraire, @RequestParam String Message ) {
			
			@SuppressWarnings("unused")
			Rendezvous rdv = rendezvousService.createrdv( id,Nom,Prenom,Age,NumTelephone,Speciality,PlageHoraire,Message );
			return "Cobra Medical/index";	
			
		}
		
}
