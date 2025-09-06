package com.Project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	
	@Id
	private String email;
	private String name;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String username) {
		this.email = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserDetails [ "+email + " : " + password + " ]";
	}
}
