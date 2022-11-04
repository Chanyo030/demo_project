package com.example.demo_project.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonReq {
	@JsonProperty ("person_id")                          //識別化(顯示用 如果不是要特別命名什麼 可寫可不寫)
	private String id;                                   //不寫就以這行的屬性名稱為主
	
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
