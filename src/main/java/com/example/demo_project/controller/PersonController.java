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

@RestController // 用於回傳 JSON、XML等資料，但不能回傳 HTML 頁面，相當於 @Controller + @ResponseBody

public class PersonController {

	@Autowired
	// 要取得PersonRes就得先呼叫Service(包括那些設定好的 值/個人資料) 託管
	private PersonService personService;

	@PostMapping(value = "/api/getPonersonInfo") //// 對 外
	// 取得多個 個人資料
	public PersonRes getPonersonInfo() {
		PersonRes pres = new PersonRes(); // 此處的pres沒有東西
		List<Person> personList = new ArrayList<>(); // 設置一個新的list清單放入待會從pres裡取得的東西
		personList = personService.getPonersonInfo(); // personService裡有設定好的值，所以從那邊取得資料就用get
		// List<Person> PersonList = personService.getPonersonInfo(); //也可直接放進陣列清單，兩者無差異
		pres.setPersonList(personList); // 並將其資料個別放入空的陣列清單裡
		// pres.setPersonList(personService.getPonersonInfo());
		return pres; // 回傳回去給PersonRes
	}

	@PostMapping(value = "/api/getPersonInfoById")
	// 因為要單一個資料，所以直接回傳Person
	public Person getPersonInfoById(@RequestBody PersonReq preq) { // @RequestBody 將外部使用者輸入對應到內部
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
//		//presage.setPersonList(personService.getPonersonInfoByAgeLargerThan(preq.getAge()));   //preq.getAge這句是JSON裡的PersonRes(結果)
//	return presage;

		PersonRes res = new PersonRes();

		List<Person> list = new ArrayList<>();
		list = personService.getPonersonInfoByAgeLargerThan(preq.getAge());

		res.setPersonList(list);

		return res;
	}

	// DB連接 第四題 姓名跟年齡一樣
	@PostMapping(value = "/api/findByNameAndAge")
	public PersonRes findByNameAndAge(@RequestBody PersonReq preq) {
		PersonRes personRes = new PersonRes();
//				personService.findByNameAndAge(preq.getName(),preq.getAge());
		personRes.setPersonList(personService.findByNameAndAge(preq.getName(), preq.getAge()));
		return personRes;
	}

	// DB連接 第五題 姓名一樣 年齡大於年齡
	@PostMapping(value = "/api/findByNameAndAgeGreaterThan")
	public PersonRes findByNameAndAgeGreaterThan(@RequestBody PersonReq preq) {
		PersonRes personRes = new PersonRes();
		// personService.findByNameAndAgeGreaterThan(preq.getName(),preq.getAge());
		personRes.setPersonList(personService.findByNameAndAgeGreaterThan(preq.getName(), preq.getAge()));
		return personRes;

	}
}
