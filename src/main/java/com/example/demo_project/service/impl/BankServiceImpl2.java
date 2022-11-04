package com.example.demo_project.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Bank2;
import com.example.demo_project.repository.BankDao2;
import com.example.demo_project.service.ifs.BankService2;
import com.example.demo_project.vo.BankRes2;



@Service
public class BankServiceImpl2 implements BankService2 {
	@Autowired
	private BankDao2 bankDao2;

	@Override
	public BankRes2 createAccount(String account) {
    	BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); 
		if (optional.isPresent()) {
			bankRes2.setMessage("帳戶名稱重複 無法創建");
			return bankRes2;
		}
		if(!StringUtils.hasText(account)) {
			bankRes2.setMessage("帳戶名不得為空");
			return bankRes2;
		}
		Bank2 bank2 = new Bank2();
		bank2.setAccount(account);
//		bank2.setAmount(0);        //因為int預設值本身是0，所以這行可有可無
		bankRes2.setBank2(bank2);
		bankRes2.setMessage("帳號創建成功");
		bankDao2.save(bank2);
		return bankRes2;
		
//		//方法2
//		if(!account.equalsIgnoreCase(bankDao2.findById(account).get())) {
//			Bank2 bank2 = new Bank2();
//			bank2.setAccount(account);
//			bank2.setAmount(0);
//			bankDao2.save(bank2);			
//			return bank2;
			
	}
	

	@Override
	public BankRes2 getAmount(String account) {
		BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); // 此處Id代表主鍵
		if (optional.isPresent()) {
			Bank2 bank2 = optional.get();
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("成功找到帳戶");
			return bankRes2;
		} else {
			bankRes2.setMessage("找不到帳戶");
			return bankRes2;
		}

	}

	@Override
	public BankRes2 deopsit(String account, int deopsitAmount) {
		BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); // 此處Id代表主鍵
		if (optional.isPresent()) {
			if (deopsitAmount <= 0) {
				bankRes2.setMessage("存款不得小於0");
				return bankRes2;
			}
			Bank2 bank2 = optional.get();
			bank2.setAmount(deopsitAmount + bank2.getAmount());
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("存款成功");
			bankDao2.save(bank2); // 將存款總金額加進BD
			return bankRes2;
		} else {
			bankRes2.setMessage("找不到帳戶");
			return bankRes2;
		}
	}

	@Override
	public BankRes2 widraw(String account, int widrawAmount) {
		BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); // 此處Id代表主鍵
		if (optional.isPresent()) {
			if (widrawAmount < 0) {
				bankRes2.setMessage("提款不得小於0");
				return bankRes2;
			}
			Bank2 bank2 = optional.get();
			if (widrawAmount > bank2.getAmount()) {
				bankRes2.setMessage("提款金額不得多於存款金額 餘額不足");
				return bankRes2;
			}
			bank2.setAmount(bank2.getAmount() - widrawAmount);
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("存款成功");
			bankDao2.save(bank2); // 將存款總金額加進BD save:把資料放進BD裡
			return bankRes2;
		} else {
			bankRes2.setMessage("找不到帳戶");
			return bankRes2;
		}
	}

	// ===================課堂測試====================
	@Transactional // 通常用在多筆資料(針對@Transactional 裡的所有資料 對BD新增、刪除、修改) DB顯示結果 要馬全部成功 要馬全部失敗
	@Override
	public void deleteAccount(String account) throws RuntimeException {
		bankDao2.deleteById(account);
		System.out.println("Delete account success");
		throw new RuntimeException("Creat account Error!!");
	}

//	@Transactional   // Transaction交易    Transactional 事務
	@Override
	public void deleteByName(String name) throws RuntimeException {
		bankDao2.deleteByName(name);
		System.out.println("Delete account success");
	}

}
