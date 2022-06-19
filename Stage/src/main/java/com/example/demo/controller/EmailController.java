package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.EmailMessage;
import com.example.demo.service.EmailSenderService;

@Controller
public class EmailController {

    private  EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
 
    
    @GetMapping("/nouveauMail")
    public String nouveaumessage(){
        return "Cobra Medical/ContactFrom_v1/sendmail";
    }
    
    
  // @RequestMapping(value = "/nouveauMailp" )
   // public String nouveaumail(Model m) {
    	
   
    //	EmailMessage sendMessage = new EmailMessage();
    	
    	//Génération automatique de l'Id
    	
    	//m.addAttribute("sendMessage",sendMessage);
    //return "Cobra Medical/ContactFrom_v1/sendmail";
   // }
   // @PostMapping(path="/send-email",consumes="application/json")
   // @ResponseStatus(code=HttpStatus.CREATED)
   // public void sendEmail(@RequestBody EmailMessage emailMessage) {
     //   this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
      //  return ResponseEntity.ok("Success"); 
    //}

    @PostMapping(path="/sendemail",  consumes = "application/json")
    public ResponseEntity<String> sendEmail(Model m,@RequestBody EmailMessage emailMessage) {
    	this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
    	//EmailMessage emailMess = new EmailMessage();
    	//m.addAttribute(emailMessage);
    	return ResponseEntity.ok("Success");
    }
    @PostMapping(path="/sendemail",  consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<String> sendEmail1(Model m,EmailMessage emailMessage) {
    	this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
    //	EmailMessage emailMess = new EmailMessage();
    //	m.addAttribute(emailMessage);
    	return ResponseEntity.ok("Success");
    }
    //public ResponseBody sendEmail(Model m,@RequestBody EmailMessage emailMessage) {
    //	m.addAttribute("emailMail", emailMessage);
      //  this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
       // return (ResponseBody) ResponseEntity.ok("Success");
   // }

       // @PostMapping(path="/items", consumes="application/json")
       // @ResponseStatus(code=HttpStatus.CREATED)
       // public void createItem(@RequestBody Item item) {
            // ...
       // }

    
    
    
}
