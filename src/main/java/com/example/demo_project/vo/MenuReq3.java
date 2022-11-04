package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuReq3 {
	@JsonProperty("name")              //�s�W�\�I�~��
	private String addfood;
	@JsonProperty("price")              //�s�W�\�I����
	private int addprice;
	
	@JsonProperty("quantity")              //�s�W�\�I���q
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
