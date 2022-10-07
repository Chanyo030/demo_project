package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {
	
	public Person getPersonInfo (String id);    //介面主要是用來定義方法而已，不能實作 
	
	public void printPersonAttributes(Person person);
}
