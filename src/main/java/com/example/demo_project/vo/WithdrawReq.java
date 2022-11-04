package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithdrawReq {
	
	@JsonProperty("account")
	private String account;
	
	@JsonProperty("withdrawAmount")
	private int withdrawAmount;
	
	@JsonProperty("message")
	private String message;
	
	public WithdrawReq(String account, int withdrawAmount,String message) {
		this.account = account;
		this.withdrawAmount = withdrawAmount;
		this.message = message;
	}

	public WithdrawReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(int withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
