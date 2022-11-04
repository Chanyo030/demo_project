package com.example.demo_project.entity;

public class Bank {

	private String account;    //±b∏π
	private int amount = 1000;       //æl√B
	
	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	

	public Bank() {
	}

	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
