package com.example.demo_project;


import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.example.demo_project.controller.BankController;
//import com.example.demo_project.controller.OrderController;
//import com.example.demo_project.entity.Bank;
import com.example.demo_project.entity.Menu;
//import com.example.demo_project.service.ifs.BankService;
import com.example.demo_project.service.ifs.OrderService;
//import com.example.demo_project.vo.BankReq;
//import com.example.demo_project.vo.BankRes;
//import com.example.demo_project.vo.DepositReq;
//import com.example.demo_project.vo.MenuReq2;
//import com.example.demo_project.vo.MenuRes2;

@SpringBootTest
public class UnitTest {

//	@Autowired
//	private BankService bankService;
//	
//	@Test
//	public void test() {
//	  Bank bank = new Bank("kdvmod",1000);  //取的餘額1000元
//	  bankService.getAmount(bank);
//	  
//	  bankService.deposit(bank,500);
//	  bankService.withdraw(bank,2000); 
//	}
//	
	
		
	@Autowired
//	private BankController bankController;
	
	private OrderService orderService;
	
	@Test
	public void addonlyfoodTest() {
		Menu beef = new Menu("beef", 100);
		Menu pork = new Menu("pork", 90);
		Menu chicken = new Menu("chiacken", 80);
		orderService.addonlyfood(beef);
		orderService.addonlyfood(pork);
		orderService.addonlyfood(chicken);
		System.out.println("==============================");
	}
	
	@Test
	public void getTotalPrice() {
	Menu beef = new Menu("beef", 100);
	Menu pork = new Menu("pork", 90);
	Menu chicken = new Menu("chiacken", 80);
	Map<Menu, Integer> menuOder = new HashMap<>();
	menuOder.put(beef, 3);
	menuOder.put(pork, 6);
	menuOder.put(chicken, 5);
	orderService.getTotalPrice(menuOder);
	System.out.println("==============================");
	}
	
	@Test
	public void printOrder() {
		Map<Menu, Integer> menuOder = new HashMap<>();
		menuOder.put(new Menu("beef", 100),3);
		menuOder.put(new Menu("pork", 90),6);
		menuOder.put(new Menu("chicken", 80),5);
		orderService.printOrder(menuOder);    //將menuOder裡設定好的值套入OrderService中printOrdere公式做計算
		orderService.getTotalPrice(menuOder);  //將計算好的值(menuOder)帶入getTotalPrice去做折扣後的價格
		                                                 //最後回傳給menuOder這個Map清單並印出
	}
}
	/*
	public void bankController() {
		BankReq req = new BankReq();
//		req.setAccount("A01");
		BankRes res = bankController.getAmount(req);
		System.out.println(res.getAccount());
		System.out.println(res.getAmount());
		System.out.println(res.getMessage());
	}
	
	//===============================================
	@Autowired
	private BankController bankController1;
	
	
	@Test
	public void bankController1() {
		DepositReq dreq = new DepositReq();
		dreq.setAccount1("A02");
		dreq.setDepodit(200);
		BankRes dres = bankController1.deposit(dreq);
		System.out.println(dres.getAmount());
		System.out.println(dres.getAccount());
		System.out.println(dres.getMessage());
	}
	
	@Autowired
	private OrderController orderController;
	
	@Test
	public void orderController() {
//		MenuReq2 mreq2 = new MenuReq2();
//		mreq2.setName(mreq2.getName());
//		mreq2.setPrice(mreq2.getPrice());
//		MenuRes2 mres = orderController.getMenu2(mreq2);
//		System.out.println(mres.getName());
//		System.out.println(mres.getPrice());
	}
	}*/
	
