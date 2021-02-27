package com.example.kansyoku_kiroku.model.domain;

import com.example.kansyoku_kiroku.model.form.UserForm;

public class User {
	
	private int userId;
	private String userName;
	private String email;
	private String password;
	
	public User() {}
	
	public User(UserForm f) {
		userName = f.getUserName();
		email = f.getEmail();
		password = f.getPassword();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
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
	

}
