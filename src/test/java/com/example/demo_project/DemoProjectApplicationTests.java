package com.example.demo_project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.entity.Person;
import com.example.demo_project.service.ifs.Active;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.service.impl.ActiveImpl;

@SpringBootTest
class DemoProjectApplicationTests { // 執行是點 JUnit test

	@Autowired
	private PersonService personService;
	
	@Autowired
	private Active active;
	
//	@Autowired
//	private ActiveImpl activeImpl;
	
	

//	@Test // 用於測試方法
//	public void contextLoads() {
//
//	}

	@Test
	public void teacher() {
	   Person person = personService.getPersonInfo("YYY");
	   personService.printPersonAttributes(person);
	}
	
	@Test
	public void activeTest() {  //
		Bird bird = active.fly("Bird", 20);
		active.printbird(bird);
	}

}
