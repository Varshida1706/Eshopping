package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

	String username;
	String password;
	String email;
	String contact;
	
	public User(String username, String password, String email, String contact) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.contact = contact;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", contact=" + contact
				+ "]";
	}
	
}
