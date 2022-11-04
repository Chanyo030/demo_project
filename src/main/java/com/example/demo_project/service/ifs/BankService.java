package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bank;
import com.example.demo_project.vo.BankRes;

public interface BankService {
	public Bank getAmount (String account); //���o�l�B
	public Bank deposit(String account, int depodit);   //�s��
	public BankRes withdraw(String account, int withdraw );   //����
}
