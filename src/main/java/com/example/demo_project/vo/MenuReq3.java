package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuReq3 {
	@JsonProperty("name")              //新增餐點品項
	private String addfood;
	@JsonProperty("price")              //新增餐點價格
	private int addprice;
	
	@JsonProperty("quantity")              //新增餐點份量
	private int quantity;
	
	public MenuReq3() {
		
	}

	public MenuReq3(String addfood, int addprice, String getMenu, String getOnlyoneFood, String order, int quantity) {
		this.addfood = addfood;
		this.addprice =addprice;
		this.quantity = quantity;
	}

	public String getAddfood() {
		return addfood;
	}

	public void setAddfood(String addfood) {
		this.addfood = addfood;
	}

	public int getAddprice() {
		return addprice;
	}

	public void setAddprice(int addprice) {
		this.addprice = addprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
	
}
