package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Person;

public interface PersonService {

//	public Person getPersonInfo (String id);    //�����D�n�O�Ψөw�q��k�Ӥw�A�����@ 
//	
//	public void printPersonAttributes(Person person);
//========================================================================
	public List<Person> getPonersonInfo(); // get all Persons

	public Person getPersonInfoById(String id); // get Person by id

	public List<Person> getPonersonInfoByAgeLargerThan(int age);

	// DB�s�� �ĥ|�D �m�W��~�֤@��
	public List<Person> findByNameAndAge(String name, int age);

	// DB�s�� �Ĥ��D �m�W�@�� �~�֤j��~��
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);

}
