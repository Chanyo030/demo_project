package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

//import com.fasterxml.jackson.annotation.JsonInclude;

public class BankRes {          //�^��(�L�X�F��)
	
	private String account;   //�b��
	private int amount;    //�l�B
	
	@JsonProperty("msg")
	private String message;   //�����A �ާ@�O�_���\�Υ���
	

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
