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
	// �@�Ӥ�k
	public BankRes2 createAccount(@RequestBody BankReq2 breq) { // @RequestBody �OMapping(�M��)�N��A���~��json�̪��Ѽ�Mapping��req��
		return bankService2.createAccount(breq.getAccount());
	}

	@PostMapping(value = "/api/getAmount2")
	// �@�Ӥ�k
	public BankRes2 getAmount(@RequestBody BankReq2 breq) {
		return bankService2.getAmount(breq.getAccount());
	}

	@PostMapping(value = "/api/deopsit2") // Post:Http����k
	// �@�Ӥ�k
	public BankRes2 deopsit(@RequestBody BankReq2 breq) {
		return bankService2.deopsit(breq.getAccount(), breq.getDeopsit());
	}

	@PostMapping(value = "/api/widraw2")
	// �@�Ӥ�k
	public BankRes2 widraw(@RequestBody BankReq2 breq) {
		return bankService2.widraw(breq.getAccount(), breq.getWidraw());
	}

	// ===================�Ұ����====================
	@PostMapping(value = "/api/deleteAccount")
	// �@�Ӥ�k
	public BankRes2 deleteAccount(@RequestBody BankReq2 breq) throws Exception {
		bankService2.deleteAccount(breq.getAccount());
		return new BankRes2(new Bank2(), "success");
	}

	@PostMapping(value = "/api/deleteByName")
	// �@�Ӥ�k
	public BankRes2 deleteByName(@RequestBody BankReq2 breq) throws Exception {
		bankService2.deleteByName(breq.getName());
		return new BankRes2(new Bank2(), "success");
	}

}
