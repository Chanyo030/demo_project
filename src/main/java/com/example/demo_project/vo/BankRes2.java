package com.example.demo_project.vo;

import com.example.demo_project.entity.Bank2;

public class BankRes2 {

	private Bank2 bank2;

	private String message;

	public BankRes2() {

	}

	public BankRes2(Bank2 bank2, String message) {
		this.bank2 = bank2;
		this.message = message;
	}

	public Bank2 getBank2() {
		return bank2;
	}

	public void setBank2(Bank2 bank2) {
		this.bank2 = bank2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
