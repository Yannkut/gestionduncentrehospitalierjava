package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;


@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	
	private  JavaMailSender mailSender;



	public ContactService(JavaMailSender mailSender) {
	super();
	this.mailSender = mailSender;
}
	
	//Create operation
	public Contact createcontact(int id, String name,String email, String subject, String content) {
		 
		return contactRepository.save(new Contact (id, name, email,subject,content));
	}

	//public Contact createcontactp(int id, String name,String email, String subject, String content) {
		 
	//	return contactRepository.save(new Contact (id, name, email,subject,content));
	//}
	public List<Contact> getAll(){
		return contactRepository.findAll();
	}
	public Contact getByName(String name) {
		return contactRepository.findByName(name);
	}
	
	//Update operation
	public Contact update(String name,String email, String subject, String content) {
		Contact ct = contactRepository.findByName(name);
		ct.setEmail(email);
		ct.setSubject(subject);
		ct.setContent(content);
		return contactRepository.save(ct);
	}
	//Delete operation
	public void deleteAll() {
		contactRepository.deleteAll();
	}
	public void delete(int id) {
		Contact ct = contactRepository.findById(id);
		contactRepository.delete(ct);
	}
	

	
	
	public Contact get(int id) {
		return contactRepository.findById(id);
	}
	public void sendEmail() {
		SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
		//simpleMailMessage.setFrom("yannkut44@gmail.com");
		simpleMailMessage.setTo("ladifmailsender@gmail.com");
		simpleMailMessage.setSubject("");
		simpleMailMessage.setText("");
		mailSender.send(simpleMailMessage);
	}
	
}

