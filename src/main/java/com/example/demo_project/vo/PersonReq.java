package com.example.demo_project.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonReq {
	@JsonProperty ("person_id")                          //�ѧO��(��ܥ� �p�G���O�n�S�O�R�W���� �i�g�i���g)
	private String id;                                   //���g�N�H�o�檺�ݩʦW�٬��D
	
	private int age;
	
	private String name;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
}
