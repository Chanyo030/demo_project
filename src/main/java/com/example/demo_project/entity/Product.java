package com.example.demo_project.entity;

public class Product {
	private String name; //�ӫ~�W
	private int price;  //����
	private int quantitly;  //�ʶR�ƶq
	private int storage;  // �w�s
	public static int myMoney;
	
	
	
	public Product(String name, int price, int storage) {
		this.name = name;
		this.price = price;
		this.storage = storage;
	}

	public Product() {
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

	public int getQuantitly() {
		return quantitly;
	}

	public void setQuantitly(int quantitly) {
		this.quantitly = quantitly;
	}

	public int getStorage() {
		return storage;
	}

	public void setStorage(int storage) {
		this.storage = storage;
	}

	public static int getMyMoney() {
		return myMoney;
	}

	public static void setMyMoney(int myMoney) {
		Product.myMoney = myMoney;
	}

	

	
	
}
