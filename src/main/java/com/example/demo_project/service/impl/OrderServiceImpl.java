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
		System.out.println("�\�I�~���G" + menu.getName() + " �\�I����G" + menu.getPrice() + " ��");
	}

	@Override
	public int getTotalPrice(Map<Menu, Integer> itemMap) {
		int totalPrice = 0;
		for(Entry<Menu,Integer> item : itemMap.entrySet()) {
			Menu menu = item.getKey();              //���oMenu�̪�name �M price�ݩ�
			int itemPrice = menu.getPrice();         //�qmeun�̨��o�U���\�I�~������
			int num = item.getValue();               // �qMAP�M��̨��o�]�m���\�I���q
			totalPrice += itemPrice * num;         //�`���B =  ��@�\�I�~������ * ��@�\�I���q
		}
		if(totalPrice >= 500) {
			totalPrice= (int)  (totalPrice * 0.9);      //�]�����X�ӷ|�Odouble�A�]���[�J(int)�A�Ndouble�૬��int
		}
		System.out.println("�`�p�G" + totalPrice + " ��");
		return totalPrice;
	}

	@Override
	public void printOrder(Map<Menu, Integer> itemMap) {
		for(Entry<Menu, Integer> item: itemMap.entrySet()) {
			Menu menu = item.getKey();
			System.out.println("�\�I�G" + menu.getName() + " ���q�G" + item.getValue() + " ����G" + menu.getPrice() * item.getValue() + " ��");
		}
	}
	

	

	
	

}
