package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositReq {

	@JsonProperty("account1")
	private String account1;
	
	@JsonProperty("depositAmount")
	private int depositAmount;

	public DepositReq(String account1, int depodit) {
		this.account1 = account1;
		this.depositAmount = depodit;
	}

	public DepositReq() {
		
	}

	public String getAccount1() {
		return account1;
	}

	public void setAccount1(String account1) {
		this.account1 = account1;
	}

	public int getDepodit() {
		return depositAmount;
	}

	public void setDepodit(int depodit) {
		this.depositAmount = depodit;
	}
	
	

	
	
	
	
	
}
