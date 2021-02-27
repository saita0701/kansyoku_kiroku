package com.example.kansyoku_kiroku.model.domain;

import java.util.Date;

import com.example.kansyoku_kiroku.model.form.MenuForm;

public class Menu {
	
	private int userId;
	private int menuId;
	private String menuName;
	private int price;
	private int kcal;
	private String shop;
	private String memo;
	private Date createdDate;

	public Menu() {}
	
	public Menu(MenuForm f) {
		userId = f.getUserId();
		menuName = f.getMenuName();
		price = f.getPrice();
		kcal = f.getKcal();
		shop = f.getShop();
		memo = f.getMemo();
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
