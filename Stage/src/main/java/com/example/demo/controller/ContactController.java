package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.configuration.SecurityConfiguration;
import com.example.demo.model.Contact;
import com.example.demo.model.Patient;
import com.example.demo.service.ConsultationService;
import com.example.demo.service.ContactService;
import com.example.demo.service.RendezvousService;
import com.example.demo.service.SequenceGeneratorService;
import com.example.demo.service.TraitementService;
import com.lowagie.text.pdf.AcroFields.Item;

@Controller

public class ContactController {
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
	@Autowired
	private  ContactService contactService;
	
@Autowired
private JavaMailSender mailSender;



//@GetMapping ("/contact")
//public String login() {
	//return"Contact/newContactus";
//}
@GetMapping("/contactus")
public String adminpatient(){
    return "Admin/Contactus/gestioncontactus";
}
@GetMapping("/gestioncontact")
public String gestioncontact(){
    return "Contact/gestioncontact";
}

@RequestMapping(value = "/nouveauContact" )
public String nouveauContact(Model m) {
	Contact contact = new Contact();
	
	//Génération automatique de l'Id
	contact.setId(sgs.getSequenceNumber(Contact.SEQUENCE_NAME));
	m.addAttribute("contact",contact);
	return "Admin/Contactus/newContactus";	
}
@RequestMapping(value = "/nouveauContactp" )
public String nouveauContact2(Model m) {
	Contact contact = new Contact();
	
	//Génération automatique de l'Id
	contact.setId(sgs.getSequenceNumber(Contact.SEQUENCE_NAME));
	m.addAttribute("contact",contact);
	return "Cobra Medical/ContactFrom_v1/index";
	
	
}

@RequestMapping(value = "/createcontact", method = RequestMethod.POST)


public String createct(@RequestParam int id , @RequestParam String name, @RequestParam String email, @RequestParam String subject,@RequestParam String content ) {
	
	@SuppressWarnings("unused")
	Contact c  = contactService.createcontact( id,name,email,subject,content );
	return "Admin/Contactus/gestioncontactus";	
	
}

@RequestMapping(value = "/createcontactp", method = RequestMethod.POST)


public String creactp(@RequestParam int id , @RequestParam String name, @RequestParam String email, @RequestParam String subject,@RequestParam String content ) {
	
	@SuppressWarnings("unused")
	Contact c  = contactService.createcontact( id,name,email,subject,content );
	return "Cobra Medical/index";	
	
}

//@RequestMapping(value = "/sendmail", method = RequestMethod.POST)


//public String sendm( ) {
	
	//@SuppressWarnings("unused")
	//contactService.sendEmail();
	//return "Cobra Medical/index";	
	
//}



@RequestMapping(value = "/getAllContacts" )

public String getAllContacts(Model m) {
	List<Contact> listContacts = contactService.getAll();
	m.addAttribute("listContacts", listContacts);
	return "Admin/Contactus/listcontacts";
	}




@RequestMapping(value = "/ncontact")
	
	public String submitContact(HttpServletRequest request) {
		String name =request.getParameter("name");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		 
		SimpleMailMessage message =new SimpleMailMessage();
		message.setFrom ("yannkut@gmail.com");
		message.setTo("yannickkutoglo@hotmail.fr");
		
		String mailSubject= name+"has sent a message";
		String mailContent= "Sender Name: "+ name +"\n";
		mailContent += "Sender E-mail:" + email +"\n";
		mailContent += "Subject:" + subject +"\n";
		mailContent += "Content:" + content +"\n";
		
		message.setSubject(mailSubject);
		message.setText(mailContent);
		
		mailSender.send(message);
		return "message"; 
	}


	
}





