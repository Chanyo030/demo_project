package com.example.demo_project.vo;

import java.util.List;

import com.example.demo_project.entity.Person;

public class PersonRes {

	private List<Person> PersonList;

	public List<Person> getPersonList() {
		return PersonList;
	}

	public void setPersonList(List<Person> personList) {
		PersonList = personList;
	}

}
