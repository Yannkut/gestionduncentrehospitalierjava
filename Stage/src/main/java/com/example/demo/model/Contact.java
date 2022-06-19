/**
 * 
 */
package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 *
 */

public class Contact implements Serializable {
	   /**
	 * 
	 */
	 @Transient
	 public static final String SEQUENCE_NAME = "contact_sequence";
	 
	private static final long serialVersionUID = 4858964922277461999L;
	/**
	 * 
	 */
	@Id
	
	    private int id;
	    
	    private String name;
	    
	    private String email;
	   
	    private String subject ;
	    private String  content;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
	
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Contact other = (Contact) obj;
			return Objects.equals(email, other.email) && id == other.id && Objects.equals(content, other.content)
					&& Objects.equals(name, other.name) && Objects.equals(subject, other.subject);
		}
		public Contact(int id, String name, String email, String subject, String content) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.subject = subject;
			this.content = content;
		}
		public Contact() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", content="
					+ content + "]";
		}
	    
	   
	    
	    
	    
	




		







		
		
}
