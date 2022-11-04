package com.example.demo_project.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.constants.RegisterRtnCode;
import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.example.demo_project.vo.RegisterRes;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao registerDao;

	@Override
	public Register register(String account, String pwd, String name, int age, String city) {
		//不得註冊已存在的帳號
		if(registerDao.existsById(account)) {          //如果存在
			return null;
		}
		Register reg = new Register(account,  pwd, name, age, city);
		reg.setRegtime(new Date());      //new Date() 表示系統當前時間
//		reg.setActive(false);         //Active為boolean , boolean預設值本身為flase，因此可寫可不寫   Active激活
		reg.setRole("General");     //角色(權限)   General 一般
		return registerDao.save(reg);
	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional <Register> regOp = registerDao.findById(account);   //Register這個物件是被Optional包起來
		if(regOp.isPresent()) {      //reg是否有東西(存在)
			Register register = regOp.get();
			register.setActive(true);
			registerDao.save(register);
			return new RegisterRes(null,RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null,RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional <Register> regOp = registerDao.findById(account);   //到BD裡看是否有資料(account)，把資料放入一個叫regOp的Optional <Register>空間
		if(regOp.isPresent()) {      //判斷regOp是否有東西
			Set<String> roleSet = new HashSet<>();     //Set作用 --> 不允許重複的值存在   此行：去除參數裡的重複值
			for(String item : roleList) {           //對roleList做foreach:將roleList重複的值去掉
				roleSet.add(item);
			}
			//去除BD裡已存在的值和參數的值，兩者的重複部分
			Register reg = regOp.get();
			String role = reg.getRole();      //可能會有多個，用英文逗號(,)區隔; 例如:General, SA, PM
//			System.out.println(role);
			String[ ] roleArray = role.split(",");    //split 把字串分隔開   用(",")切分：切分多個值
			for(String item : roleArray) {
				String str = item.trim();           //trim():去除字串前後空白
				roleSet.add(str);
			}
//			System.out.println(roleSet.toString());          //轉成字串
//			System.out.println(roleSet.toString().substring(1, 7));   //substring()去除中括號
//			System.out.println(roleSet.toString().length());   //8
//			System.out.println(roleSet.toString().substring(1, roleSet.toString().length() - 1));
			String newStr = roleSet.toString().substring(1,roleSet.toString().length()-1);
			reg.setRole(newStr);
//			reg.setRole(roleSet.toString());
			registerDao.save(reg);
			return new RegisterRes(reg,RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null,RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	}

	@Override 
	public RegisterRes addRoleSet(String account, Set<String>roleSet) {
		Optional <Register> regOp = registerDao.findById(account);   //到BD裡看是否有資料(account)，把資料放入一個叫regOp的Optional <Register>空間
		if(regOp.isPresent()) {      //判斷regOp是否有東西
			
			//去除BD裡已存在的值和參數的值，兩者的重複部分
			Register reg = regOp.get();
			String role = reg.getRole();      //可能會有多個，用英文逗號(,)區隔; 例如:General, SA, PM

			String[ ] roleArray = role.split(",");    //split 把字串分隔開   用(",")切分：切分多個值
			for(String item : roleArray) {
				String str = item.trim();           //trim():去除字串前後空白
				roleSet.add(str);
			}
			
			String newStr = roleSet.toString().substring(1,roleSet.toString().length()-1);
			reg.setRole(newStr);
			registerDao.save(reg);
			return new RegisterRes(reg,RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null,RegisterRtnCode.ADD_ROLE_FAILURE.getMessage());
	} 
}
