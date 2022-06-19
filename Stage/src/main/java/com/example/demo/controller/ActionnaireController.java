package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ActionnaireController {

	 @GetMapping("/gestion")
	    
	    public String gestion(){
	        return "Actionnaires/gestion";
	    }
	 @GetMapping("/centres")
	    
	    public String gestioncentre(){
	        return "Actionnaires/centre";
	    }
	 @GetMapping("/centreParis")
	    
	    public String gestionParis(){
	        return "Actionnaires/centreParis";
	    }
	 @GetMapping("/centreSuisse")
	    
	    public String gestioSuisses(){
	        return "Actionnaires/centreSuisse";
	    }
	 @GetMapping("/centreCanada")
	    
	    public String gestionCanada(){
	        return "Actionnaires/centreCanada";
	    }
	 @GetMapping("/Listemployeesp")
	    
	    public String gestionemployees(){
	        return "Actionnaires/CENTREPARIS/List";
	    }
}
