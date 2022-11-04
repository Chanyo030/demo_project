package com.example.demo_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonReq;
import com.example.demo_project.vo.PersonRes;

@RestController // �Ω�^�� JSON�BXML����ơA������^�� HTML �����A�۷�� @Controller + @ResponseBody

public class PersonController {

	@Autowired
	// �n���oPersonRes�N�o���I�sService(�]�A���ǳ]�w�n�� ��/�ӤH���) �U��
	private PersonService personService;

	@PostMapping(value = "/api/getPonersonInfo") //// �� �~
	// ���o�h�� �ӤH���
	public PersonRes getPonersonInfo() {
		PersonRes pres = new PersonRes(); // ���B��pres�S���F��
		List<Person> personList = new ArrayList<>(); // �]�m�@�ӷs��list�M���J�ݷ|�qpres�̨��o���F��
		personList = personService.getPonersonInfo(); // personService�̦��]�w�n���ȡA�ҥH�q������o��ƴN��get
		// List<Person> PersonList = personService.getPonersonInfo(); //�]�i������i�}�C�M��A��̵L�t��
		pres.setPersonList(personList); // �ñN���ƭӧO��J�Ū��}�C�M���
		// pres.setPersonList(personService.getPonersonInfo());
		return pres; // �^�Ǧ^�h��PersonRes
	}

	@PostMapping(value = "/api/getPersonInfoById")
	// �]���n��@�Ӹ�ơA�ҥH�����^��Person
	public Person getPersonInfoById(@RequestBody PersonReq preq) { // @RequestBody �N�~���ϥΪ̿�J�����줺��
		Person person = personService.getPersonInfoById(preq.getId());
		return person;
	}

	@PostMapping(value = "/api/getPonersonInfoByAgeLargerThan")
	public PersonRes getPonersonInfoByAgeLargerThan(@RequestBody PersonReq preq) {
//		PersonRes presage = new PersonRes(); 
//		
//		List<Person> personage = personService.getPonersonInfoByAgeLargerThan(preq.getAge());
//		presage.setPersonList(personage);
//		
//		//presage.setPersonList(personService.getPonersonInfoByAgeLargerThan(preq.getAge()));   //preq.getAge�o�y�OJSON�̪�PersonRes(���G)
//	return presage;

		PersonRes res = new PersonRes();

		List<Person> list = new ArrayList<>();
		list = personService.getPonersonInfoByAgeLargerThan(preq.getAge());

		res.setPersonList(list);

		return res;
	}

	// DB�s�� �ĥ|�D �m�W��~�֤@��
	@PostMapping(value = "/api/findByNameAndAge")
	public PersonRes findByNameAndAge(@RequestBody PersonReq preq) {
		PersonRes personRes = new PersonRes();
//				personService.findByNameAndAge(preq.getName(),preq.getAge());
		personRes.setPersonList(personService.findByNameAndAge(preq.getName(), preq.getAge()));
		return personRes;
	}

	// DB�s�� �Ĥ��D �m�W�@�� �~�֤j��~��
	@PostMapping(value = "/api/findByNameAndAgeGreaterThan")
	public PersonRes findByNameAndAgeGreaterThan(@RequestBody PersonReq preq) {
		PersonRes personRes = new PersonRes();
		// personService.findByNameAndAgeGreaterThan(preq.getName(),preq.getAge());
		personRes.setPersonList(personService.findByNameAndAgeGreaterThan(preq.getName(), preq.getAge()));
		return personRes;

	}
}
