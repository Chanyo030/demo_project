package com.example.demo_project.service.ifs;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;

@Service
public interface OrderService {
	
	public void addonlyfood (Menu menu);                             //新增並取得單一品項之價格
	public int getTotalPrice (Map<Menu,Integer> itemMap);        //取得餐點總價格及500打九折
	public void printOrder (Map<Menu, Integer> itemMap);        //印出餐點內容 + 份量 + 該品項總價格，及全部餐點總金額

}
