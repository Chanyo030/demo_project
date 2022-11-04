package com.example.demo_project.vo;

import java.util.List;
import java.util.Map;

import com.example.demo_project.entity.Menu3;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)            //@JsonInclude(JsonInclude.Include.NON_NULL) 隱藏null
public class MenuRes3 {
	
	private Menu3 menu3;
	
	private List<Menu3>menuList3;
	
	private String message;

	private Map<String, Integer> map3;                   // 把餐點名稱及數量存入MAP
	
	private List<String> messageList;

	public MenuRes3() {
		
	}


	public MenuRes3(Menu3 menu3, List<Menu3> menu3List, String message) {
		super();
		this.menu3 = menu3;
		this.menuList3 = menu3List;
		this.message = message;
	}


	public Menu3 getMenu3() {
		return menu3;
	}

	public void setMenu3(Menu3 menu3) {
		this.menu3 = menu3;
	}
	

	public List<Menu3> getMenu3List() {
		return menuList3;
	}

	public void setMenuList3(List<Menu3> menu3List) {
		this.menuList3 = menu3List;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public Map<String, Integer> getMap3() {
		return map3;
	}


	public void setMap3(Map<String, Integer> map3) {
		this.map3 = map3;
	}


	public List<String> getMessageList() {
		return messageList;
	}


	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
	
}
