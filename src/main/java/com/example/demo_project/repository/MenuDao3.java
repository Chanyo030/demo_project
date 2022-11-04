package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Menu3;

@Repository
public interface MenuDao3 extends JpaRepository<Menu3, String> {   //繼承Jpa的方法 <Entity,Entity裡的@Id的屬性型態>
	
}
