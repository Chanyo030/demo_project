package com.example.demo_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_project.entity.Person;

@Repository // ��spring boot�U�� <entity��class�W��,�D�䪺��ƫ��A>
public interface PersonDao extends JpaRepository<Person, String> { // ���B��String�O�D�䪺��ƫ��A

	// �ĤT�D ���D��k2
	public List<Person> findByAgeGreaterThan(int age); // GreaterThan�j�� GreaterThanEqual �j�󵥩�

	// DB�s�� �ĥ|�D �m�W��~�֤@��
	public List<Person> findByNameAndAge(String name, int age);

	// DB�s�� �Ĥ��D �m�W�@�� �~�֤j��
	public List<Person> findByNameAndAgeGreaterThan(String name, int age);
}
