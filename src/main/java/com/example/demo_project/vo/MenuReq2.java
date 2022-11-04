package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuReq2 {
	
	@JsonProperty("beef")
	private int beefquantity;     //¤û¦×¼Æ¶q
	
	@JsonProperty("chicken")
	private int chickequantity;
	
	@JsonProperty("cake")
	private int cakequantity;

	
	
	
	public MenuReq2() {
		
	}

	

	public int getBeefquantity() {
		return beefquantity;
	}



	public void setBeefquantity(int beefquantity) {
		this.beefquantity = beefquantity;
	}



	public int getChickequantity() {
		return chickequantity;
	}



	public void setChickequantity(int chickequantity) {
		this.chickequantity = chickequantity;
	}



	public int getCakequantity() {
		return cakequantity;
	}



	public void setCakequantity(int cakequantity) {
		this.cakequantity = cakequantity;
	}



	
	
	
	
	
	
}
