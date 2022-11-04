package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonInclude;

public class BankRes {          //回應(印出東西)
	
	private String account;   //帳號
	private int amount;    //餘額
	
	@JsonProperty("msg")
	private String message;   //提醒你 操作是否成功或失敗
	

	public BankRes(String account, int amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
	}

	public BankRes() {
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
