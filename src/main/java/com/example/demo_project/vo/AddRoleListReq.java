package com.example.demo_project.vo;

import java.util.List;

public class AddRoleListReq {
	
	private String account;
	
	private List<String> roleList;
	
	public AddRoleListReq() {
		
	}

	public AddRoleListReq(String account, List<String> roleList) {
		this.account = account;
		this.roleList = roleList;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}
	
}
