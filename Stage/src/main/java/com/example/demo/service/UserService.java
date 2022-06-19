package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.model.User;
import com.example.demo.repository.RendezvousRepository;
import com.example.demo.repository.UserRepository;


@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RendezvousRepository rendezvousRepository;
	//Create operation
	public User createuser(int id, String username, String password, int active, String roles, String permissions) {
		 
		return userRepository.save(new User (id, username, password, active ,roles,permissions));
	}
	
	public User pcreateusers(int id, String confirmPassword, String username, String password, int active, String roles, String permissions) {
		 
		return userRepository.save(new User (id, confirmPassword, username, password, active ,roles,permissions));
	}
	
	public User puser( int id,String username,String password, int active, String roles) {
		 
		return userRepository.save(new User ( id, username, password, active, roles));
	}
	//public User createusernrdv(int id, String username, String password, int active, String roles,Rendezvous rendezvous) {
		 
		//return userRepository.save(new User (id, username, password, active ,roles));
		//return RendezvousRepository.save(new Rendezvous (id, username, password, active ,roles));
	//}
	
	//Retrieve operation
	public List<User> getAll(){
		return userRepository.findAll();
	}
	

	public User getUsername(String username) {
		return userRepository.findByUsername(username);
	}
	public User getByPassword(String password) {
		return userRepository.findByPassword(password);
	}

	public List <User> getByRoles(String roles) {
		return userRepository.findByRoles("roles");
	}
	
	
	
	//Update operation
	public User update(String username,String password, int active,String roles, String permissions) {
		User us = userRepository.findByUsername(username);
		us.setUsername(username);
		us.setPassword(password);
		us.setRoles(roles);
		us.setPermissions(permissions);
	
		
		return userRepository.save(us);
	}
	//Delete operation
	public void deleteAllUsers() {
		userRepository.deleteAll();
	}
	public void deleteuser(int id) {
		User us = userRepository.findById(id);
		userRepository.delete(us);
	}
	

	
	public User getuser(int id) {
		return userRepository.findById(id);
	}

  
  
    public void countusers() {
        long count = userRepository.count();
        System.out.println("Number of documents in the collection: " + count);
    }
 
	
}