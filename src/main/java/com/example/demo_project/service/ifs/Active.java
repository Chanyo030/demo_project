package com.example.demo_project.service.ifs;

import com.example.demo_project.entity.Bird;

public interface Active {
//	void fly(String name,int age);
		public Bird fly(String name,int age);
		
		public void printbird (Bird bird);
}
