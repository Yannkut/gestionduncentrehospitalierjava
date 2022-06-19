package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Actionnaire;
import com.example.demo.model.Comptable;
import com.example.demo.model.Médecin;
import com.example.demo.model.Patient;
import com.example.demo.model.Secrétaire;
import com.example.demo.model.User;


public interface UsersServices {
	


	//User 
public User createuser(int id, String username, String password, int active, String roles, String permissions);
public User pcreateusers(int id, String confirmPassword, String username, String password, int active, String roles, String permissions);
public User puser( int id,String username,String password, int active, String roles); 
public List<User> getAll();
public User getuser(int id);
public void deleteAllUsers();
public void deleteuser(int id);
public User getUsername(String username);
public User getByPassword(String password);
public User update(String username,String password, int active,String roles, String permissions);

//Patient
public void addUserToPatient(String username, String name);
public Patient create(int id, String name,String sexe, String ville, String job, int age);
public List<Patient> getAllP();
public Patient getByNamep(String name);
public Patient updatep(String name,String sexe, String ville, String job, int age);
public Patient updatepu(String name,String sexe, String ville, String job, int age,int id, String username, String password, int active, String roles, String permissions);
public void deleteAllp(); 
public void deletep(int id);
public Patient getp(int id);
Patient createPatient(Patient patient);
//Actionnaire
public void addUserToActionnaire(String username, String name);
Actionnaire createActionnaire(Actionnaire actionnaire);
//Secrétaire
public void addUserToSecrétaire(String username, String name);
Secrétaire createSecrétaire(Secrétaire secrétaire);
//Comptable
public void addUserToComptable(String username, String name);
Comptable createComptable(Comptable comptable);
//Médecin
public void addUserToMédecin(String username, String name);
Médecin createMédecin(Médecin medecin);











}






