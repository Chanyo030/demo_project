package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person;

@Repository // 請spring boot託管 <entity的class名稱,主鍵的資料型態>
public interface PersonDao extends JpaRepository<Person, String> { // 此處的String是主鍵的資料型態

	// 第三題 解題方法2
	public List<Person> findByAgeGreaterThan(int age); // GreaterThan大於 GreaterThanEqual 大於等於

	// DB連接 第四題 姓名跟年齡一樣
	public List<Person> findByNameAndAge(String name, int age);

	// DB連接 第五題 姓名一樣 年齡大於
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
}
