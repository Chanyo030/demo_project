package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank2;
import com.example.demo_project.service.ifs.BankService2;
import com.example.demo_project.vo.BankReq2;
import com.example.demo_project.vo.BankRes2;

@RestController

public class BankController2 {
	@Autowired
	private BankService2 bankService2;

	@PostMapping(value = "/api/createAccount")
	// 一個方法
	public BankRes2 createAccount(@RequestBody BankReq2 breq) { // @RequestBody 是Mapping(映對)意思，讓外部json裡的參數Mapping到req中
		return bankService2.createAccount(breq.getAccount());
	}

	@PostMapping(value = "/api/getAmount2")
	// 一個方法
	public BankRes2 getAmount(@RequestBody BankReq2 breq) {
		return bankService2.getAmount(breq.getAccount());
	}

	@PostMapping(value = "/api/deopsit2") // Post:Http的方法
	// 一個方法
	public BankRes2 deopsit(@RequestBody BankReq2 breq) {
		return bankService2.deopsit(breq.getAccount(), breq.getDeopsit());
	}

	@PostMapping(value = "/api/widraw2")
	// 一個方法
	public BankRes2 widraw(@RequestBody BankReq2 breq) {
		return bankService2.widraw(breq.getAccount(), breq.getWidraw());
	}

	// ===================課堂測試====================
	@PostMapping(value = "/api/deleteAccount")
	// 一個方法
	public BankRes2 deleteAccount(@RequestBody BankReq2 breq) throws Exception {
		bankService2.deleteAccount(breq.getAccount());
		return new BankRes2(new Bank2(), "success");
	}

	@PostMapping(value = "/api/deleteByName")
	// 一個方法
	public BankRes2 deleteByName(@RequestBody BankReq2 breq) throws Exception {
		bankService2.deleteByName(breq.getName());
		return new BankRes2(new Bank2(), "success");
	}

}
