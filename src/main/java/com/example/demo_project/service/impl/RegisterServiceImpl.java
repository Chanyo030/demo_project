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
		//���o���U�w�s�b���b��
		if(registerDao.existsById(account)) {          //�p�G�s�b
			return null;
		}
		Register reg = new Register(account,  pwd, name, age, city);
		reg.setRegtime(new Date());      //new Date() ��ܨt�η�e�ɶ�
//		reg.setActive(false);         //Active��boolean , boolean�w�]�ȥ�����flase�A�]���i�g�i���g   Active�E��
		reg.setRole("General");     //����(�v��)   General �@��
		return registerDao.save(reg);
	}

	@Override
	public RegisterRes activeAccount(String account) {
		Optional <Register> regOp = registerDao.findById(account);   //Register�o�Ӫ���O�QOptional�]�_��
		if(regOp.isPresent()) {      //reg�O�_���F��(�s�b)
			Register register = regOp.get();
			register.setActive(true);
			registerDao.save(register);
			return new RegisterRes(null,RegisterRtnCode.SUCCESSFUL.getMessage());
		}
		return new RegisterRes(null,RegisterRtnCode.FAILURE.getMessage());
	}

	@Override
	public RegisterRes addRole(String account, List<String> roleList) {
		Optional <Register> regOp = registerDao.findById(account);   //��BD�̬ݬO�_�����(account)�A���Ʃ�J�@�ӥsregOp��Optional <Register>�Ŷ�
		if(regOp.isPresent()) {      //�P�_regOp�O�_���F��
			Set<String> roleSet = new HashSet<>();     //Set�@�� --> �����\���ƪ��Ȧs�b   ����G�h���ѼƸ̪����ƭ�
			for(String item : roleList) {           //��roleList��foreach:�NroleList���ƪ��ȥh��
				roleSet.add(item);
			}
			//�h��BD�̤w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole();      //�i��|���h�ӡA�έ^��r��(,)�Ϲj; �Ҧp:General, SA, PM
//			System.out.println(role);
			String[ ] roleArray = role.split(",");    //split ��r����j�}   ��(",")�����G�����h�ӭ�
			for(String item : roleArray) {
				String str = item.trim();           //trim():�h���r��e��ť�
				roleSet.add(str);
			}
//			System.out.println(roleSet.toString());          //�ন�r��
//			System.out.println(roleSet.toString().substring(1, 7));   //substring()�h�����A��
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
		Optional <Register> regOp = registerDao.findById(account);   //��BD�̬ݬO�_�����(account)�A���Ʃ�J�@�ӥsregOp��Optional <Register>�Ŷ�
		if(regOp.isPresent()) {      //�P�_regOp�O�_���F��
			
			//�h��BD�̤w�s�b���ȩM�Ѽƪ��ȡA��̪����Ƴ���
			Register reg = regOp.get();
			String role = reg.getRole();      //�i��|���h�ӡA�έ^��r��(,)�Ϲj; �Ҧp:General, SA, PM

			String[ ] roleArray = role.split(",");    //split ��r����j�}   ��(",")�����G�����h�ӭ�
			for(String item : roleArray) {
				String str = item.trim();           //trim():�h���r��e��ť�
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
