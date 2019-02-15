package com.padmini.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {

	@Id
 //   @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String lastname;
	private String password;
	
	public Login()
	{}
	
	public Login(String lastname, String password) {
		super();
		this.lastname = lastname;
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
