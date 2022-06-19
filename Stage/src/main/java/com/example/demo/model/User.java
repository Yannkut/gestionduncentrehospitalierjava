package com.example.demo.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
public class User {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	 

	


@Id  
   
    private int id;

    private String confirmPassword;
    private String username;


    private String password;

    private int active;

    private String roles = "";

    private String permissions = "";
  
   
    private List<Rendezvous>rendezvous; 
    
	public User(int id, String confirmPassword, String username, String password, int active, String roles,
			String permissions, Rendezvous rendezvous) {
		super();
		this.id = id;
		this.confirmPassword = confirmPassword;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
		this.id=id;
		
	}


	public User(int id, String username, String password, int active, String roles, String permissions,
			List<Rendezvous> rendezvous) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
		this.rendezvous = rendezvous;
	}


	public User(String username, String password,int active, String roles, String permissions){
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.permissions = permissions;
        this.active = 1;
    }
    

    public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String username, String password, int active, String roles, String permissions) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		
		this.roles = roles;
		this.permissions = permissions;
		this.active=1;
	}




    public User(int id, String confirmPassword, String username, String password, int active, String roles,
			String permissions) {
		super();
		this.id = id;
		this.confirmPassword = confirmPassword;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
		this.permissions = permissions;
	}

  

	public User(int id, String username, String password, int active, String roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.active = active;
		this.roles = roles;
	
	}
	





	public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setId(int id) {
		this.id = id;
	}
    

	public void setActive(int active) {
		this.active = active;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	

	public String getConfirmPassword() {
		return confirmPassword;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}


	public List<String> getRoleList(){
        if(this.roles.length() > 0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getPermissionList(){
        if(this.permissions.length() > 0){
           return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }



    
}