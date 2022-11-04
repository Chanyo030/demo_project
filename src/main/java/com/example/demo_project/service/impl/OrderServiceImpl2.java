package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu2;
import com.example.demo_project.service.ifs.OrderService2;

@Service
public class OrderServiceImpl2 implements OrderService2 {
	private String beef = "beef";
	private String chicken = "chicken";
	private String cake = "cake";

	@Override
	public Menu2 getMenu2() {
		Menu2 menu = new Menu2();
		menu.getMap().put(beef, 100);
		menu.getMap().put(chicken, 800);
		menu.getMap().put(cake, 220);
		return menu;
	}

	//==========================================
	@Override
	public Menu2 OrderMoney() {
		Menu2 menu = new Menu2();
		menu.getMap().put(beef, 100);
		menu.getMap().put(chicken, 800);
		menu.getMap().put(cake, 220);
		
		menu.getOrdermap().put(beef, 6);
		menu.getOrdermap().put(chicken, 3);
		menu.getOrdermap().put(cake, 2);
		

		Map<String, Integer> map222 = new HashMap<>();
		map222 = menu.getMap();
		
		Map<String, Integer> map223 = new HashMap<>();
		map223 = menu.getOrdermap();

		int totalamount = 0 ;
		
		for (Map.Entry<String, Integer> entry : map222.entrySet()) {
			for (Map.Entry<String, Integer> entry1 : map223.entrySet()) {
				if(entry.getKey().equalsIgnoreCase(entry1.getKey())) {
					totalamount = totalamount+ entry.getValue()*entry1.getValue();
					}
				}
			
			}
			if(totalamount>500) {
				totalamount = (int) (totalamount*0.9);
			}
			
			menu.setPrice(totalamount);
		return menu;
	}

}
