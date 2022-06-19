package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.service.ContactService;

@SpringBootApplication
public class StageApplication {
	
@Autowired
private ContactService contactService;

	public static void main(String[] args) {
		SpringApplication.run(StageApplication.class, args);
	}
//@EventListener(ApplicationReadyEvent.class)

//public void sendMail(){
	//contactService.sendEmail("ladifmailsender@gmail.com",
		//	"This is the Subject",
			//"This is the Body of the Email");
//}
}



