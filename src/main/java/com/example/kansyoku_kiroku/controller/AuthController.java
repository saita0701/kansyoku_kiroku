package com.example.kansyoku_kiroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kansyoku_kiroku.model.domain.User;
import com.example.kansyoku_kiroku.model.form.UserForm;
import com.example.kansyoku_kiroku.model.mapper.UserMapper;
import com.example.kansyoku_kiroku.model.session.LoginSession;
import com.google.gson.Gson;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private Gson gson = new Gson();
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/login")
	public String login(@RequestBody UserForm f) {
		User user = userMapper.findByUserNameAndPassword(f.getUserName(), f.getPassword());
		
		if(user != null) {
			loginSession.setLogined(true);
			loginSession.setUserId(user.getUserId());
			loginSession.setUserName(user.getUserName());
			loginSession.setPassword(user.getPassword());
		}
		return gson.toJson(user);
	}
	
	@RequestMapping("/logout")
	public String logout() {
		loginSession.setLogined(false);
		loginSession.setUserId(0);
		loginSession.setUserName(null);
		loginSession.setPassword(null);
		return "";
	}
}
