package com.example.demo_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Menu3;

@Repository
public interface MenuDao3 extends JpaRepository<Menu3, String> {   //�~��Jpa����k <Entity,Entity�̪�@Id���ݩʫ��A>
	
}
