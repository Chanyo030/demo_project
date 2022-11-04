package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.vo.BankRes;

public interface BankService {
	public Bank getAmount (String account); //取得餘額
	public Bank deposit(String account, int depodit);   //存款
	public BankRes withdraw(String account, int withdraw );   //提款
}
