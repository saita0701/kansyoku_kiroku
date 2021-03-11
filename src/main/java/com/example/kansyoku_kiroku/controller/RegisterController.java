package com.example.kansyoku_kiroku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.kansyoku_kiroku.model.domain.User;
import com.example.kansyoku_kiroku.model.form.UserForm;
import com.example.kansyoku_kiroku.model.mapper.UserMapper;
import com.google.gson.Gson;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserForm userForm;
	
	Gson gson = new Gson();
	
	@RequestMapping("/")
	public String register() {
		return "register";
	}

	@RequestMapping("/submit")
	@ResponseBody
	public String register(@RequestBody UserForm f) {
		User user = new User(f);
		int count = userMapper.insertUser(user);
		if(count > 0) {
			return gson.toJson(user);
		} else {
			return "";
		}
	}
}
