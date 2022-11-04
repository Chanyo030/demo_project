package com.example.demo_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  //跟spring說我要把這個Person class 宣告成一個實體類 (你要去跟DB的某一張表做連結)
@Table(name = "person") //跟spring說你想要去連結哪一張表 (對應的表的名稱)
public class Person {             // entity
	
	@Id   //指表中的主鍵
	@Column(name = "id")   //person這張表裡面的欄位名稱
	private String id;     //屬性
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
//	private String city;

	public Person(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
}
