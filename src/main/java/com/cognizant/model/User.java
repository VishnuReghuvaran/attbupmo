package com.cognizant.model;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="User")
public class User {
	
	
	 private String username;
	 private String password;
	 private String passwordConfirm;
	 private Set<Role> roles;
	 
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
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	 

}
