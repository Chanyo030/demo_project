package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;


import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankRes;

@Service
public class BankServiceImpl implements BankService {

	//取得餘額
	@Override
	public Bank getAmount(String account) { //帶入帳號 取得餘額
		Bank bank = new Bank();
		bank.setAccount(account); //帳號
		bank.setAmount(1000);     //餘額
		return bank;
	}

	//存款
	@Override
	public Bank deposit(String account,int deposit) { //deposit存款金額
		int initAmount = 500;
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(initAmount + deposit);
		return bank;  
	}
	
	//提款
	@Override
	public BankRes withdraw(String account, int withdraw) { //withdraw提款金額
		int initAmount = 500;
		BankRes bres = new BankRes();
		if(withdraw > initAmount) {
			bres.setMessage("餘額不足 無法提款");
			return bres;
		}
		Bank bank = new Bank();
		bank.setAccount(account);      //帳號
		bank.setAmount(initAmount - withdraw);     //餘額-提款金額
		bres.setAccount(bank.getAccount());
		bres.setAmount(bank.getAmount());
		bres.setMessage("Success 提款成功");
		return bres; 
	}
}

	
	
	
//	@Autowired   // @Autowired 即可以直接使用，不須再重新 new 此物件 
//	private Bank bank;
	
	
//	public void deposit(Bank bank) {         //存款
//		
//	}
//	
//
//	public void withdraw(Bank bank) {          //提款
//		
//	}
	


