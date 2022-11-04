package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.demo_project.entity.Menu3;
import com.example.demo_project.repository.MenuDao3;
import com.example.demo_project.service.ifs.OrderService3;
import com.example.demo_project.vo.MenuReq3;
import com.example.demo_project.vo.MenuRes3;

@Service
public class OrderService3Impl implements OrderService3 {

	@Autowired
	private MenuDao3 menuDao3;

	@Override
	public MenuRes3 addfood(String name, int price) {
		MenuRes3 menuRes3 = new MenuRes3();
		Optional<Menu3> optional = menuDao3.findById(name);
		if (optional.isPresent()) {
			menuRes3.setMessage("餐點名稱重複 無法創建");
			return menuRes3;
		}
		if (!StringUtils.hasText(name)) {
			menuRes3.setMessage("餐點名稱不得為空 無法創建");
			return menuRes3;
		}
		Menu3 menu3 = new Menu3();
		menu3.setName(name);
		menu3.setPrice(price);
		menuRes3.setMenu3(menu3);
		menuRes3.setMessage("餐點品項新增成功");
		menuDao3.save(menu3);
		return menuRes3;
	}

	@Override
	public List<Menu3> getMenu() {
//		List<Menu3> menuReqList3 = new ArrayList<>();
//		menuReqList3 = menuDao3.findAll();
		List<Menu3> menuReqList3 = menuDao3.findAll();
		
		
		return menuReqList3;
	}

	@Override
	public MenuRes3 getOnlyoneFood(String name) {
		MenuRes3 menuRes3 = new MenuRes3();
		Optional<Menu3> optional = menuDao3.findById(name);

		if (!optional.isPresent()) {
			menuRes3.setMessage("查無餐點品項");
			return menuRes3;
		}
		menuRes3.setMenu3(optional.orElse(new Menu3()));
		return menuRes3;
	}

	@Override
	public MenuRes3 order(List<MenuReq3> mreq) {
		MenuRes3 menuRes3 = new MenuRes3();
		Map<String, Integer> map3 = new HashMap<>(); // 把餐點名稱及數量存入MAP
		List<String> messageList = new ArrayList<>(); // 把提示訊息存入Array
		int totalamount = 0;
		for (MenuReq3 mreq3 : mreq) {
			Optional<Menu3> optional = menuDao3.findById(mreq3.getAddfood()); // 比對BD資料庫內容
			if (StringUtils.hasText(mreq3.getAddfood())) {
				if (optional.isPresent()) {                                                       // 如果有東西(符合)就取得餐點名稱及價格
					if (mreq3.getQuantity() <= 0) {
						mreq3.setQuantity(0);
					}
					totalamount = totalamount + optional.get().getPrice() * mreq3.getQuantity(); // optional.get().getPrice()
																									// 從BD取得餐點單一價格來計算
					map3.put(mreq3.getAddfood(), mreq3.getQuantity());
					messageList.add("餐點名稱：" + mreq3.getAddfood() + "," + "份量：" + mreq3.getQuantity() + "," + "總價格："
							+ optional.get().getPrice() * mreq3.getQuantity());
				} else {
					map3.put(mreq3.getAddfood(), 0);
					messageList.add(mreq3.getAddfood() + "餐點品項不存在，價格與數量皆為0");
				}
			}
			menuRes3.setMap3(map3);
		}
		if(totalamount>=500) {
			totalamount = (int) (totalamount * 0.9);
			messageList.add("總金額超過500元,打九折：" + totalamount);
		}else {
			messageList.add("總金額未超過500元,原價：" + totalamount);
		}
		menuRes3.setMessageList(messageList);
		return menuRes3;
	}
}
