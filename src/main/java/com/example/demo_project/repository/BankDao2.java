package com.example.demo_project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Bank2;

//Dao�O�ΨӰ���ƳB�z��

@Repository // �~��JPA�̭�����k
//===================�Ұ����====================
@Transactional
//================================================
public interface BankDao2 extends JpaRepository<Bank2, String> {

	// ===================�Ұ����====================

	public void deleteByName(String name);

}
