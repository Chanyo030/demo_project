package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Person;

public interface PersonService {
	
	public Person getPersonInfo (String id);    //�����D�n�O�Ψөw�q��k�Ӥw�A�����@ 
	
	public void printPersonAttributes(Person person);
}
