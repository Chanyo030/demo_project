package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankReq {          //請求東西
	//@JsonInclude(JsonInclude.Include.NON_NULL)   //避免Json印出null(實體類與json互轉的時候屬性值為null的不參與序列化)
	
	@JsonProperty("account")
	private String account;
	
	@JsonProperty("deposit")
	private int deposit;
	
	@JsonProperty("withdrawamount")
	private int withdrawamount;
	

	public BankReq() {
	
	}

	public BankReq(String account, int deposit, int withdrawamount) {
		this.account = account;
		this.deposit = deposit;
		this.withdrawamount = withdrawamount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdrawamount() {
		return withdrawamount;
	}

	public void setWithdrawamount(int withdrawamount) {
		this.withdrawamount = withdrawamount;
	}
}
