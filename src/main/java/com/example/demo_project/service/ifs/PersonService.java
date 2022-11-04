package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Person;

public interface PersonService {

//	public Person getPersonInfo (String id);    //介面主要是用來定義方法而已，不能實作 
//	
//	public void printPersonAttributes(Person person);
//========================================================================
	public List<Person> getPonersonInfo(); // get all Persons

	public Person getPersonInfoById(String id); // get Person by id

	public List<Person> getPonersonInfoByAgeLargerThan(int age);

	// DB連接 第四題 姓名跟年齡一樣
	public List<Person> findByNameAndAge(String name, int age);

	// DB連接 第五題 姓名一樣 年齡大於年齡
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);

}
