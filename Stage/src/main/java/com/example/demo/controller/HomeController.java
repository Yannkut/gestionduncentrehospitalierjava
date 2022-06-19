package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository; 



@Controller
@CrossOrigin

@RequestMapping("/")

public class HomeController {
    @SuppressWarnings("unused")
	private UserRepository userRepository;

    public HomeController(UserRepository userRepository){
        this.userRepository = userRepository;
    }	
	
	@GetMapping("/")
	public String index() {
		return"Cobra Medical/index";
	}

	
	
	@GetMapping ("login")
	public String login() {
		return"Cobra Medical/Login/index";
	}


	
	 
	  
	@RestController  
	public class MyRestController {  
	    @GetMapping("/example")  
	    public String example() {  
	        return "Hello Actuator !! ";  
	    }  
	}
	
		
		
	}
	

