package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankReq;
import com.example.demo_project.vo.BankRes;
import com.example.demo_project.vo.DepositReq;
import com.example.demo_project.vo.WithdrawReq;

@RestController          //�N�������k�^�Ǫ������ন���w�榡
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping(value ="/api/getAmount")   //��http�̪�Post
	public BankRes getAmount(@RequestBody BankReq request) {   //�۷��z�Lhttp�ШD�P�^��
//		String account = bank.getAccount();
//		int amount = bank.getAmount();
		BankRes res = new BankRes();
//		String account = request.getAccount();
//		if (account == null || account.isEmpty()) {
//			res.setMessage("Account is empyt!");
//			return res;
//		}
//		System.out.println(account.isEmpty());
		if(!StringUtils.hasText(request.getAccount())) {  //�o�r�ꤤ�t����r
			res.setMessage("Account is empyt!");
		return res;
		}
		Bank bank = bankService.getAmount(request.getAccount());
		res.setAccount(bank.getAccount());
		res.setAmount(bank.getAmount());
		res.setMessage("Succese");
		return res;
	}
	
	//==========================================
	@PostMapping(value = "/api/depositAmount")           //API URL: API���w��
	public BankRes deposit(@RequestBody BankReq request) {
		BankRes dres = new BankRes();
		if(!StringUtils.hasText(request.getAccount())) {
			dres.setMessage("Account is empyt!");
			return dres;
		}
		else if(request.getDeposit()< 0) {
			dres.setMessage("�s�J���B����p��s�Τj��s�ڪ��B");
			return dres;
		}
		
		Bank bank = bankService.deposit(request.getAccount(),request.getDeposit());
		dres.setAccount(bank.getAccount());
		dres.setAmount(bank.getAmount());
		dres.setMessage("Succeseful");
		return dres;
	}
	//==========================================
	@PostMapping(value = "/api/getwithder") 
	public BankRes withder1 (@RequestBody BankReq bankReq) {
		BankRes bres = new BankRes();
		if(!StringUtils.hasText(bankReq.getAccount())) {
			bres.setMessage("Account is empyt!");
			return bres;
		}
		if(bankReq.getWithdrawamount()< 0) {
			bres.setMessage("���ڪ��B����p��s�Τj��s�ڪ��B");
			return bres;	
		}
		BankRes bank = bankService.withdraw(bankReq.getAccount(),bankReq.getWithdrawamount());
		bres.setAccount(bank.getAccount());
		bres.setAmount(bank.getAmount());
		bres.setMessage("Succeseful");
		return bres;
	}
	
	
	
}
