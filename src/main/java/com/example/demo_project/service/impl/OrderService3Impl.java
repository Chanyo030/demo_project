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
			menuRes3.setMessage("�\�I�W�٭��� �L�k�Ы�");
			return menuRes3;
		}
		if (!StringUtils.hasText(name)) {
			menuRes3.setMessage("�\�I�W�٤��o���� �L�k�Ы�");
			return menuRes3;
		}
		Menu3 menu3 = new Menu3();
		menu3.setName(name);
		menu3.setPrice(price);
		menuRes3.setMenu3(menu3);
		menuRes3.setMessage("�\�I�~���s�W���\");
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
			menuRes3.setMessage("�d�L�\�I�~��");
			return menuRes3;
		}
		menuRes3.setMenu3(optional.orElse(new Menu3()));
		return menuRes3;
	}

	@Override
	public MenuRes3 order(List<MenuReq3> mreq) {
		MenuRes3 menuRes3 = new MenuRes3();
		Map<String, Integer> map3 = new HashMap<>(); // ���\�I�W�٤μƶq�s�JMAP
		List<String> messageList = new ArrayList<>(); // �ⴣ�ܰT���s�JArray
		int totalamount = 0;
		for (MenuReq3 mreq3 : mreq) {
			Optional<Menu3> optional = menuDao3.findById(mreq3.getAddfood()); // ���BD��Ʈw���e
			if (StringUtils.hasText(mreq3.getAddfood())) {
				if (optional.isPresent()) {                                                       // �p�G���F��(�ŦX)�N���o�\�I�W�٤λ���
					if (mreq3.getQuantity() <= 0) {
						mreq3.setQuantity(0);
					}
					totalamount = totalamount + optional.get().getPrice() * mreq3.getQuantity(); // optional.get().getPrice()
																									// �qBD���o�\�I��@����ӭp��
					map3.put(mreq3.getAddfood(), mreq3.getQuantity());
					messageList.add("�\�I�W�١G" + mreq3.getAddfood() + "," + "���q�G" + mreq3.getQuantity() + "," + "�`����G"
							+ optional.get().getPrice() * mreq3.getQuantity());
				} else {
					map3.put(mreq3.getAddfood(), 0);
					messageList.add(mreq3.getAddfood() + "�\�I�~�����s�b�A����P�ƶq�Ҭ�0");
				}
			}
			menuRes3.setMap3(map3);
		}
		if(totalamount>=500) {
			totalamount = (int) (totalamount * 0.9);
			messageList.add("�`���B�W�L500��,���E��G" + totalamount);
		}else {
			messageList.add("�`���B���W�L500��,����G" + totalamount);
		}
		menuRes3.setMessageList(messageList);
		return menuRes3;
	}
}
