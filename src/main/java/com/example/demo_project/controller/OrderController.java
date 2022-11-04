package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Menu2;
import com.example.demo_project.service.ifs.OrderService2;
import com.example.demo_project.vo.MenuReq2;
import com.example.demo_project.vo.MenuRes2;

@RestController 
public class OrderController {
	@Autowired
	OrderService2 orderService2;
	
	@PostMapping(value = "/api/getMenu2")
	public MenuRes2 getMenu2 (@RequestBody MenuReq2 request) {
		MenuRes2 mres = new MenuRes2();
		Menu2 menu2 = orderService2.getMenu2();
		mres.setMap(menu2.getMap());
		return mres;
	}
	
	
	
	@PostMapping(value = "/api/OrderMoney")
	public MenuRes2 OrderMoney (@RequestBody MenuReq2 request) {
		MenuRes2 mres2 = new MenuRes2();
		Menu2 menu22 = orderService2.OrderMoney();
		mres2.setMap(menu22.getMap());
		mres2.setOrdermap(menu22.getOrdermap());
		mres2.setPrice(menu22.getPrice());
		return mres2;
		
	}
}
