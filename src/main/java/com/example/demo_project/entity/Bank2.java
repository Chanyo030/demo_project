package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank")
public class Bank2 {

	@Id
	@Column(name = "account")
	private String account;

	@Column(name = "amount")
	private int amount;

	// ===================½Ò°ó´ú¸Õ====================
	@Column(name = "name")
	private String name;
	// ================================================

	public Bank2() {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
