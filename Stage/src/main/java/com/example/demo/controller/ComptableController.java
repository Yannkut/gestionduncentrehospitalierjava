package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Facture;
import com.example.demo.service.FactureService;
import com.example.demo.service.SequenceGeneratorService;


@Controller
public class ComptableController  {
	

	@Autowired
	private SequenceGeneratorService sgs;
	
	@Autowired
	private FactureService factureService;

		
		   @GetMapping("/comptable")
		    public String comptableparis(){
		        return "Comptable/gestioncomptable";
		    }
		   
		   @GetMapping("/cpgestionFacture")
		    public String cpgestionfacture(){
		        return "Comptable/gestionfacturecp";
		   }
		 //---------Début Facture//________________
		   
		
		   //Nouvelle Facture
			  
		    @RequestMapping(value = "/nouvelleFacture" )
			public String cpnouvellefacture(Model m) {
              Facture fac= new Facture ();
				//Génération automatique de l'Id
				fac.setId(sgs.getSequenceNumber(Facture.SEQUENCE_NAME));
				m.addAttribute("facture", fac);
				return "Comptable/nouvelleFacture";	
		    }
			@RequestMapping(value = "/cpcreatefac", method = RequestMethod.POST)


			public String cpcreatefac(int id, int quantite,String designation,String nommedecin, String destfacture,int pu,int pt,String description,  Date date, int tel , String email ) {
				
				@SuppressWarnings("unused")
				Facture fac = factureService.createfac( id,  quantite, designation,nommedecin, destfacture,pu,pt,description,date, tel, email);
				return "Comptable /gestionfacturecp";	
				
			}
			@RequestMapping(value = "/ListeFactures" )

			public String mpgetAllTraitements(Model m) {
				List<Facture>listFactures = factureService.getAll();
				m.addAttribute("listFactures", listFactures);
				return "Médecin/SuivieduPatient/listTraitements";
				}

		 //---------Fin Facture//________________

	
		   
		   
		   
		   
		
			       
			    
	}

