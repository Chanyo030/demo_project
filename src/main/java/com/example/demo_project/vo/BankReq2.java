package com.example.demo_project.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankReq2 {

	@JsonProperty("account")
	private String account;

	@JsonProperty("deopsit")
	private int deopsit;

	@JsonProperty("widraw")
	private int widraw;

	// ===================½Ò°ó´ú¸Õ====================
	@JsonProperty("name")
	private String name;
	// ================================================

	public BankReq2() {

	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getDeopsit() {
		return deopsit;
	}

	public void setDeopsit(int deopsit) {
		this.deopsit = deopsit;
	}

	public int getWidraw() {
		return widraw;
	}

	public void setWidraw(int widraw) {
		this.widraw = widraw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
