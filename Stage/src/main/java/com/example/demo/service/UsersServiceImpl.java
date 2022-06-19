package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Actionnaire;
import com.example.demo.model.Comptable;
import com.example.demo.model.Médecin;
import com.example.demo.model.Patient;
import com.example.demo.model.Secrétaire;
import com.example.demo.model.User;
import com.example.demo.repository.ActionnaireRepository;
import com.example.demo.repository.ComptableRepository;
import com.example.demo.repository.MédecinRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.SecrétaireRepository;
import com.example.demo.repository.UserRepository;
@Service
public class UsersServiceImpl implements UsersServices{
	
	

	@Autowired 
	private UserRepository userRepository;
	@Autowired 
	private MédecinRepository  médecinRepository;
	@Autowired 
	private PatientRepository patientRepository;
	@Autowired 
	private SecrétaireRepository secrétaireRepository;
	@Autowired 
	private ComptableRepository  comptableRepository;
	@Autowired 
	private ActionnaireRepository actionnaireRepository;
	

	//User
	
	@Override
	public User createuser(int id, String username, String password, int active, String roles, String permissions) {
		
		 return userRepository.save(new User (id, username, password, active ,roles,permissions));
	}
	@Override
	public User pcreateusers(int id, String confirmPassword, String username, String password, int active, String roles, String permissions) {
		 
		return userRepository.save(new User (id, confirmPassword, username, password, active ,roles,permissions));
	}
	@Override
	public User puser( int id,String username,String password, int active, String roles) {
		 
		return userRepository.save(new User ( id, username, password, active, roles));
	}
	
	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User getuser(int id) {
		return userRepository.findById(id);
	}
	@Override
	public User getUsername(String username) {
		return userRepository.findByUsername(username);
	}
	@Override
	public User getByPassword(String password) {
		return userRepository.findByPassword(password);
	}
	@Override
	public User update(String username,String password, int active,String roles, String permissions) {
		User us = userRepository.findByUsername(username);
		us.setUsername(username);
		us.setPassword(password);
		us.setRoles(roles);
		us.setPermissions(permissions);		
		return userRepository.save(us);
	}

	@Override
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
	@Override
	public void deleteuser(int id) {
		User us = userRepository.findById(id);
		userRepository.delete(us);
	}
	
	
	
	//Patient
	@Override
	public void addUserToPatient(String username, String name) {
    Patient patient =patientRepository.findByName(name);
    User user=userRepository.findByUsername(username);
    patient.getUser().add(user);
		
	}
	@Override
	public Patient create(int id, String name, String sexe, String ville, String job, int age) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Patient> getAllP() {
		return patientRepository.findAll();
	}
	@Override
	public Patient getByNamep(String name) {
		return patientRepository.findByName(name);
	}
	@Override
	public Patient updatep(String name, String sexe, String ville, String job, int age) {
		
		Patient p = patientRepository.findByName(name);
		p.setSexe(sexe);
		p.setVille(ville);
		p.setJob(job);
		p.setAge(age);
		return patientRepository.save(p);
	}
	@Override
	public Patient updatepu(String name, String sexe, String ville, String job, int age, int id, String username,
			String password, int active, String roles, String permissions) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteAllp() {
		patientRepository.deleteAll();
		
	}
	@Override
	public void deletep(int id) {
		Patient p = patientRepository.findById(id);
		patientRepository.delete(p);
		
	}
	@Override
	public Patient getp(int id) {
		return patientRepository.findById(id);
	}
	//Médecin
	
	@Override
	public void addUserToMédecin(String username, String name) {
		 Médecin medecin =médecinRepository.findByName(name);
		    User user=userRepository.findByUsername(username);
		 medecin.getUser().add(user);
	
	}
	
	
	
	//Actionnaire
	@Override
	public void addUserToActionnaire(String username, String name) {
		 Actionnaire actionnaire =actionnaireRepository.findByName(name);
		    User user=userRepository.findByUsername(username);
		 actionnaire.getUser().add(user);
		
	}
	
	
	//Comptable
	@Override
	public void addUserToComptable(String username, String name) {
		 Comptable comptable =comptableRepository.findByName(name);
		    User user=userRepository.findByUsername(username);
		 comptable.getUser().add(user);
		
	}
	//Secrétaire
	//@Override
	// void addUserToSecrétaire(String username, String name) {
	//	 Secrétaire secrétaire =secrétaireRepository.findByName(name);
		   // User user=userRepository.findByUsername(username);
		// secrétaire.getUser().add(user);
		
	//}
	
	@Override
	public Patient createPatient(Patient patient) {
		
		return patientRepository.save(patient);
	}

	@Override
	public Actionnaire createActionnaire(Actionnaire actionnaire) {
		return actionnaireRepository.save(actionnaire);
	}

	@Override
	public Secrétaire createSecrétaire(Secrétaire secrétaire) {
		return secrétaireRepository.save(secrétaire);
	}

	@Override
	public Comptable createComptable(Comptable comptable) {
		return comptableRepository.save(comptable);
	}

	@Override
	public Médecin createMédecin(Médecin medecin) {
		return médecinRepository.save(medecin);
	}
	@Override
	public void addUserToSecrétaire(String username, String name) {
		// TODO Auto-generated method stub
		
	}



	

	
	
	
	
	
	


	
	





}
