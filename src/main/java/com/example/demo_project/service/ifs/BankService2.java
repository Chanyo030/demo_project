package com.example.demo_project.service.ifs;

import com.example.demo_project.vo.BankRes2;

public interface BankService2 { // interface�ݥ�public
	public BankRes2 createAccount(String account); // �إ߱b��

	public BankRes2 getAmount(String account); // ���o�l�B

	public BankRes2 deopsit(String account, int deopsitAmount); // �b��,�s��

	public BankRes2 widraw(String account, int widrawAmount); // �b��,����

	// ===================�Ұ����====================
	public void deleteAccount(String account) throws RuntimeException;

	public void deleteByName(String name);
}
