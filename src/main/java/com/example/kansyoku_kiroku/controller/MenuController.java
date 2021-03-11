package com.example.kansyoku_kiroku.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kansyoku_kiroku.model.domain.Menu;
import com.example.kansyoku_kiroku.model.form.MenuForm;
import com.example.kansyoku_kiroku.model.mapper.MenuMapper;
import com.example.kansyoku_kiroku.model.session.LoginSession;
import com.google.gson.Gson;


@RequestMapping("/kansyoku-kiroku/menu")
@RestController
public class MenuController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private MenuForm menuForm;
	
	@Autowired
	private LoginSession loginSession;
	
	Gson gson = new Gson();
	
	@RequestMapping("/insert")
	@ResponseBody
	public void registerMenu(@RequestBody MenuForm f) {
		
		if(loginSession.getUserId() > 0) {
			Menu menu = new Menu(f);
			menu.setUserId(loginSession.getUserId());
			
			Date date = new Date();
			menu.setCreatedDate(date);
			
			menuMapper.insertMenu(menu);
		}
	}
	
	@RequestMapping("/delete")
	public String deleteMenu(@RequestBody MenuForm f) {
		menuMapper.deleteById(f.getMenuId());
		return gson.toJson(f);
	}
	
	@RequestMapping("/insertMenuHistory")
	public String insertMenuHistory(@RequestBody MenuForm f) {
		Date date = new Date();
		menuForm.setMenuId(f.getMenuId());
		menuMapper.insertMenuHistory(date,loginSession.getUserId(), f.getMenuId());
		return gson.toJson(f);
	}
}
