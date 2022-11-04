package com.example.demo_project.vo;

import java.util.HashMap;
import java.util.Map;

public class MenuRes2 {

	
	private String name;
	
	private int price;
	
	Map<String,Integer> map = new HashMap<>();
	Map<String,Integer> ordermap = new HashMap<>();
	

	public MenuRes2() {
		
	}

	public MenuRes2(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Map<String, Integer> getMap() {
		return map;
	}

	public void setMap(Map<String, Integer> map) {
		this.map = map;
	}

	public Map<String, Integer> getOrdermap() {
		return ordermap;
	}

	public void setOrdermap(Map<String, Integer> ordermap) {
		this.ordermap = ordermap;
	}
	
	
	
}
