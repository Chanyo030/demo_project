package com.example.demo_project.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;
import com.example.demo_project.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService  {
	
	private Map<String,Integer> menuMap = new HashMap<>();

	@Override
	public void addonlyfood(Menu menu) {
		menuMap.put(menu.getName(), menu.getPrice());
		System.out.println("餐點品項：" + menu.getName() + " 餐點價格：" + menu.getPrice() + " 元");
	}

	@Override
	public int getTotalPrice(Map<Menu, Integer> itemMap) {
		int totalPrice = 0;
		for(Entry<Menu,Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey();              //取得Menu裡的name 和 price屬性
			int itemPrice = menu.getPrice();         //從meun裡取得各個餐點品項價格
			int num = item.getValue();               // 從MAP清單裡取得設置的餐點份量
			totalPrice += itemPrice * num;         //總金額 =  單一餐點品項價格 * 單一餐點份量
		}
		if(totalPrice >= 500) {
			totalPrice= (int)  (totalPrice * 0.9);      //因為乘出來會是double，因此加入(int)，將double轉型為int
		}
		System.out.println("總計：" + totalPrice + " 元");
		return totalPrice;
	}

	@Override
	public void printOrder(Map<Menu, Integer> itemMap) {
		for(Entry<Menu, Integer> item: itemMap.entrySet()) {
			Menu menu = item.getKey();
			System.out.println("餐點：" + menu.getName() + " 份量：" + item.getValue() + " 價格：" + menu.getPrice() * item.getValue() + " 元");
		}
	}
	

	

	
	

}
