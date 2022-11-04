package com.example.demo_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.AddRoleListReq;
import com.example.demo_project.vo.AddRoleSetReq;
import com.example.demo_project.vo.RegisterReq;
import com.example.demo_project.vo.RegisterRes;

@RestController
public class RegisterController {
	@Autowired
	private RegisterService registerService;

	@PostMapping(value = "/api/register")
	public RegisterRes register(@RequestBody RegisterReq req) {
		RegisterRes checkResult = cheakParam(req);
		if (checkResult != null) {
			return checkResult;
		}
		Register reg = registerService.register(req.getAccount(), req.getPwd(), req.getName(), req.getAge(),
				req.getCity());
		if (reg == null) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_EXISTED.getMessage());
		}
		return new RegisterRes(reg, RegisterRtnCode.SUCCESSFUL.getMessage());
	}

	private RegisterRes cheakParam(RegisterReq req) {
		if (!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes(RegisterRtnCode.ACCOUNT_REQUIRED.getMessage()); // 帳號不得為空、null
		} else if (!StringUtils.hasText(req.getPwd())) {
			return new RegisterRes(RegisterRtnCode.PWD_REQUIRED.getMessage()); // 密碼不得為空、null
		} else if (!StringUtils.hasText(req.getName())) {
			return new RegisterRes(RegisterRtnCode.NAME_REQUIRED.getMessage()); // 姓名不得為空、null
		}
		return null;

	}
	
	@PostMapping(value = "/api/activeAccount")
	public RegisterRes activeAccount (@RequestBody RegisterReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes (RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
	        return  registerService.activeAccount(req.getAccount());
//		if(result) {
//			return new RegisterRes(null,RegisterRtnCode.SUCCESSFUL.getMessage());
//		}
//		return new RegisterRes(null,RegisterRtnCode.FAILURE.getMessage());
	}
	@PostMapping(value = "/api/add_role_list")
	public RegisterRes addRoleList (@RequestBody AddRoleListReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes (RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if(req.getRoleList() == null  || req.getRoleList().isEmpty()) {
		if(CollectionUtils.isEmpty(req.getRoleList())) {
			return new RegisterRes (RegisterRtnCode.ROLE_LIST_IS_EMPTY.getMessage());//
		}
	        return  registerService.addRole(req.getAccount(),req.getRoleList());
	}
	
	@PostMapping(value = "/api/add_role_set")
	public RegisterRes addRoleSet (@RequestBody AddRoleSetReq req) {
		if(!StringUtils.hasText(req.getAccount())) {
			return new RegisterRes (RegisterRtnCode.ACCOUNT_REQUIRED.getMessage());
		}
//		if(req.getRoleSet() == null || req.getRoleSet().isEmpty()) {
		if(CollectionUtils.isEmpty(req.getRoleSet())) {
			return new RegisterRes ("RoleSet is empty");
		}
	        return  registerService.addRoleSet(req.getAccount(),req.getRoleSet());
	}
	
}


