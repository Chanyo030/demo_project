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
			bankRes2.setMessage("�b��W�٭��� �L�k�Ы�");
			return bankRes2;
		}
		if(!StringUtils.hasText(account)) {
			bankRes2.setMessage("�b��W���o����");
			return bankRes2;
		}
		Bank2 bank2 = new Bank2();
		bank2.setAccount(account);
//		bank2.setAmount(0);        //�]��int�w�]�ȥ����O0�A�ҥH�o��i���i�L
		bankRes2.setBank2(bank2);
		bankRes2.setMessage("�b���Ыئ��\");
		bankDao2.save(bank2);
		return bankRes2;
		
//		//��k2
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
		Optional<Bank2> optional = bankDao2.findById(account); // ���BId�N��D��
		if (optional.isPresent()) {
			Bank2 bank2 = optional.get();
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("���\���b��");
			return bankRes2;
		} else {
			bankRes2.setMessage("�䤣��b��");
			return bankRes2;
		}

	}

	@Override
	public BankRes2 deopsit(String account, int deopsitAmount) {
		BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); // ���BId�N��D��
		if (optional.isPresent()) {
			if (deopsitAmount <= 0) {
				bankRes2.setMessage("�s�ڤ��o�p��0");
				return bankRes2;
			}
			Bank2 bank2 = optional.get();
			bank2.setAmount(deopsitAmount + bank2.getAmount());
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("�s�ڦ��\");
			bankDao2.save(bank2); // �N�s���`���B�[�iBD
			return bankRes2;
		} else {
			bankRes2.setMessage("�䤣��b��");
			return bankRes2;
		}
	}

	@Override
	public BankRes2 widraw(String account, int widrawAmount) {
		BankRes2 bankRes2 = new BankRes2();
		Optional<Bank2> optional = bankDao2.findById(account); // ���BId�N��D��
		if (optional.isPresent()) {
			if (widrawAmount < 0) {
				bankRes2.setMessage("���ڤ��o�p��0");
				return bankRes2;
			}
			Bank2 bank2 = optional.get();
			if (widrawAmount > bank2.getAmount()) {
				bankRes2.setMessage("���ڪ��B���o�h��s�ڪ��B �l�B����");
				return bankRes2;
			}
			bank2.setAmount(bank2.getAmount() - widrawAmount);
			bankRes2.setBank2(bank2);
			bankRes2.setMessage("�s�ڦ��\");
			bankDao2.save(bank2); // �N�s���`���B�[�iBD save:���Ʃ�iBD��
			return bankRes2;
		} else {
			bankRes2.setMessage("�䤣��b��");
			return bankRes2;
		}
	}

	// ===================�Ұ����====================
	@Transactional // �q�`�Φb�h�����(�w��@Transactional �̪��Ҧ���� ��BD�s�W�B�R���B�ק�) DB��ܵ��G �n���������\ �n����������
	@Override
	public void deleteAccount(String account) throws RuntimeException {
		bankDao2.deleteById(account);
		System.out.println("Delete account success");
		throw new RuntimeException("Creat account Error!!");
	}

//	@Transactional   // Transaction���    Transactional �ư�
	@Override
	public void deleteByName(String name) throws RuntimeException {
		bankDao2.deleteByName(name);
		System.out.println("Delete account success");
	}

}
