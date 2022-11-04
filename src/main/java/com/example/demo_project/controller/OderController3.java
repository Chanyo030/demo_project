package com.example.demo_project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.service.ifs.OrderService3;
import com.example.demo_project.vo.MenuReq3;
import com.example.demo_project.vo.MenuRes3;

@RestController
public class OderController3 {
	
	@Autowired
	private OrderService3 orderService3;
	
	@PostMapping(value = "/api/addfood")
	public MenuRes3 addfood(@RequestBody MenuReq3 mreq3 ) {      //@RequestBody ��~����JSON�榡Mapping�ݩʨ�o��class�̭�
		return orderService3.addfood(mreq3.getAddfood(),mreq3.getAddprice());
	}
	
	@PostMapping(value = "/api/getMenu")              //�B�̦�}��M�A�i�Ω��khttp��Method(post/get...��)
	public MenuRes3 getMenu() {
		MenuRes3 menuRes3 = new MenuRes3();
//		List<Menu3> menuList3 = new ArrayList<>();
//		menuList3 = orderService3.getMenu();
//		menuRes3.setMenuList3(menuList3);
		menuRes3.setMenuList3(orderService3.getMenu());
		
		return menuRes3;
	}
	
	@PostMapping(value = "/api/getOnlyoneFood")
	public MenuRes3 getOnlyoneFood(@RequestBody MenuReq3 mreq3) {
		MenuRes3 menuRes3 =orderService3.getOnlyoneFood(mreq3.getAddfood());
		return  menuRes3;
	}
	
	@PostMapping(value = "/api/order")
	public MenuRes3 order(@RequestBody List<MenuReq3> mreq3) {
		MenuRes3 menuRes3 =orderService3.order(mreq3);
		return menuRes3;
		
	}
}
