package com.example.demo_project.service.ifs;

import com.example.demo_project.vo.BankRes2;

public interface BankService2 { // interface需用public
	public BankRes2 createAccount(String account); // 建立帳戶

	public BankRes2 getAmount(String account); // 取得餘額

	public BankRes2 deopsit(String account, int deopsitAmount); // 帳戶,存款

	public BankRes2 widraw(String account, int widrawAmount); // 帳戶,提款

	// ===================課堂測試====================
	public void deleteAccount(String account) throws RuntimeException;

	public void deleteByName(String name);
}
