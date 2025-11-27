package com.klu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LogIn {

	@Id
	String email;
	String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LogIn [email=" + email + ", password=" + password + "]";
	}
	
}
