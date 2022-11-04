package com.example.demo_project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Bank2;

//Dao是用來做資料處理的

@Repository // 繼承JPA裡面的方法
//===================課堂測試====================
@Transactional
//================================================
public interface BankDao2 extends JpaRepository<Bank2, String> {

	// ===================課堂測試====================

	public void deleteByName(String name);

}
