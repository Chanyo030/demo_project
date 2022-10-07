package com.example.demo_project.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Bird;
import com.example.demo_project.service.ifs.Active;

@Service
public class ActiveImpl implements Active {

	@Override
	public Bird fly(String name,int age) {
		Bird bird = new Bird();
		bird.setName(name);
		bird.setAge(age);
		return bird;
		
	}
	
	public void printbird (Bird bird) {
		System.out.println("今年" + bird.getAge() + "歲," + bird.getName() + "正在飛");
	}

}
