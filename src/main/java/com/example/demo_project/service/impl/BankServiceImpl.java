package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;


import com.example.demo_project.entity.Bank;
import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.vo.BankRes;

@Service
public class BankServiceImpl implements BankService {

	//���o�l�B
	@Override
	public Bank getAmount(String account) { //�a�J�b�� ���o�l�B
		Bank bank = new Bank();
		bank.setAccount(account); //�b��
		bank.setAmount(1000);     //�l�B
		return bank;
	}

	//�s��
	@Override
	public Bank deposit(String account,int deposit) { //deposit�s�ڪ��B
		int initAmount = 500;
		Bank bank = new Bank();
		bank.setAccount(account);
		bank.setAmount(initAmount + deposit);
		return bank;  
	}
	
	//����
	@Override
	public BankRes withdraw(String account, int withdraw) { //withdraw���ڪ��B
		int initAmount = 500;
		BankRes bres = new BankRes();
		if(withdraw > initAmount) {
			bres.setMessage("�l�B���� �L�k����");
			return bres;
		}
		Bank bank = new Bank();
		bank.setAccount(account);      //�b��
		bank.setAmount(initAmount - withdraw);     //�l�B-���ڪ��B
		bres.setAccount(bank.getAccount());
		bres.setAmount(bank.getAmount());
		bres.setMessage("Success ���ڦ��\");
		return bres; 
	}
}

	
	
	
//	@Autowired   // @Autowired �Y�i�H�����ϥΡA�����A���s new ������ 
//	private Bank bank;
	
	
//	public void deposit(Bank bank) {         //�s��
//		
//	}
//	
//
//	public void withdraw(Bank bank) {          //����
//		
//	}
	


