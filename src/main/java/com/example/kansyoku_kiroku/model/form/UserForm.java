package com.example.kansyoku_kiroku.model.form;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class UserForm implements Serializable {	
	
	private static final long serialVersionUID = 3777985114744594636L;
	
	private String userName;
	private String password;
	private String email;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
}
