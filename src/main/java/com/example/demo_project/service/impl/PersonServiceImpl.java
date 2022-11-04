package com.example.demo_project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Person;
import com.example.demo_project.repository.PersonDao;
import com.example.demo_project.service.ifs.PersonService;
import com.example.demo_project.vo.PersonReq;

@Service // ��Spring Boot�U�� �o�ˤ~����k�b��L�a��Q@Autowired
public class PersonServiceImpl implements PersonService { // ��@�O�� ��
	@Autowired
	private PersonDao personDao;

//	@Override
//	public Person getPersonInfo(String id) {
//		Person person = new Person();
//		person.setId(id);
//		person.setName("yo");
//		person.setCity("Taiwan");
//		person.setAge(16);
//		return person;
//	}
//	
//	public void printPersonAttributes(Person person) {
//		System.out.println(person.getId());
//		System.out.println(person.getName());
//		System.out.println(person.getAge());
//		System.out.println(person.getCity());
//		
//	}
	// ===============================================
	@Override
	public List<Person> getPonersonInfo() {
		// �]�w�Ҧ�person����
//		Person people = new Person("peopleid", "people", 34);
//		Person people2 = new Person("people2id", "people2", 50);
//		Person people3 = new Person("people3id", "people3", 17);

		// �N�]�w�n���ȩ�J�W��PersonList�M���

		List<Person> PersonList = new ArrayList<>(); // List<Person> �^�ǫ��A(���G�n�ŦX���A)
		PersonList = personDao.findAll(); // �NpersonDao.findAll()�s�JPersonList��

//		PersonList.add(people);
//		PersonList.add(people2);
//		PersonList.add(people3);
		// �̫�^�ǵ�PersonList --> List<Person> getPonersonInfo()

		return PersonList; // �]���O�n�C�X�Ҧ��H����T �ҥH�^��PersonList�A�Ӥ��O�^�����O��Person(�u����o�@�ӤH����T)
	}

	@Override
	public Person getPersonInfoById(String id) {
		// �]�w�Ҧ�person����
//		Person people = new Person("peopleid", "people", 34); // Json�ϥΪ̬O��JString�����Ӧ�m���e
//		Person people2 = new Person("people2id", "people2", 50);
//		Person people3 = new Person("people3id", "people3", 17);
//		List<Person> personList = new ArrayList<>();       //�Ū�PersonList�}�C�M��
//		personList = personDao.findAll();                  //��J��Ʈw�����θ��

		/*
		 * ��k1 Person person = new Person(); //�NPerson���O�F���iperson�o�ӪŶ� person =
		 * personDao.findById(id).get(); // person.setId(personDao.getById(id).getId());
		 * 
		 * return person;
		 */

		/// ========================��k2==============================
		// Optional:�bjpa���A�q�`�ϥΦb�u����@����ɫʸˡF�u����ت��A�A���ȩΨS�ȡA�i�ΨӥN��null//
//				Optional<Person> PersonOp = personDao.findById(id);
//				if(PersonOp.isPresent()) {          //isPresent:�P�w�O�_���F��(��)�A��:true
//					Person per = PersonOp.get();
//					System.out.println(per.getId());
//					System.out.println(per.getAge());
//					return PersonOp.get();
//				}else {
//					return new Person();
//				}
		/// ========================��k3==============================
//				Optional<Person> PersonOp = personDao.findById(id);
//				return personDao.findById(id).orElse(new Person());
		/// ========================��k4==============================
		Optional<Person> PersonOp = personDao.findById(id);
		return PersonOp.orElse(new Person()); // .orElse():����isPresent()�T�{���L�ȡA�p�G����^��.get();
												// �_�h(�p�G�S��)��^.orElse()������
		// �@�ӭӤ��
//		if (id.equalsIgnoreCase(people.getId())) {
//			return people;
//		}
//		if (id.equalsIgnoreCase(people2.getId())) {
//			return people2;
//		}
//		if (id.equalsIgnoreCase(people3.getId())) {
//			return people3;
//		} else {                                        // id��異�ѴN�^�ǪŪ�Person
//		return new Person();
//		}
	}

//
	@Override
	public List<Person> getPonersonInfoByAgeLargerThan(int age) {
		/*
		 * // �]�w�Ҧ�person���ȡA�ӧO�s��bPerson Class 
		 * Person people = new Person("peopleid", "people", 34); 
		 * Person people2 = new Person("people2id", "people2", 50);
		 * Person people3 = new Person("people3id", "people3", 17);
		 * 
		 * // �N�]�w�n���ȩ�J�W��PersonList�M���(�w�]��Person��T) ��J�@�Ӱ}�C��(�T���x�s��) 
		 * List<Person>PersonList = new ArrayList<>(); 
		 * PersonList.add(people);
		 * PersonList.add(people2);
		 *  PersonList.add(people3);
		 * 
		 * // -------------------------------------- // 
		 ageList ���s��ŦX����(��~�֤j)��Person��T
		 List<Person> ageList = new ArrayList<>(); 
		 for (Person bigageList :PersonList) {
		  	if (age < bigageList.getAge()) {        //�P�_�ϥΪ̿�J���~�֬O�_���p��person�ҳ]�m���Ҧ��H���~��
		 		Person personage = new Person(); 
		 		personage.setId(bigageList.getId()); 
		 		personage.setName(bigageList.getName()); 
		 		personage.setAge(bigageList.getAge()); ageList.add(bigageList); 
		  		return ageList;
		  	} 
		  }
		 */

		/*
		 �s��DB��k1
		  List<Person> get = new ArrayList<>(); 
		  get = personDao.findAll();
		  
		 List<Person> per = new ArrayList<>();
		 
		 for(Person find : get) {                       //��ﵲ�G�ŦX�̴N�|�s��per�A�ѩ�ڭ̴N�O�n�C�L�X�ŦX�����h����� 
		 if(age < find.getAge() ) { per.add(find);     //�ҥH�~�n�^�ǥ�
		   return per;
		   }
		 }
		 */
		// =========��k2
		List<Person> list = personDao.findByAgeGreaterThan(age); // findByAgeGreaterThan���P�⦡
		return list;
	}

	// DB�s�� �ĥ|�D �m�W��~�֤@��
	@Override
	public List<Person> findByNameAndAge(String name, int age) {
		List<Person> personnameandage = personDao.findByNameAndAge(name, age);
		return personnameandage;
	}

	// DB�s�� �Ĥ��D �m�W�@�� �~�֤j��~��
	@Override
	public List<Person> findByNameAndAgeGreaterThan(String name, int age) {
		List<Person> personnameandagegreaterthan = personDao.findByNameAndAgeGreaterThan(name, age);
		return personnameandagegreaterthan;

	}

}
