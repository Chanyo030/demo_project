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

@Service // 讓Spring Boot託管 這樣才有辦法在其他地方被@Autowired
public class PersonServiceImpl implements PersonService { // 實作是對 內
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
		// 設定所有person的值
//		Person people = new Person("peopleid", "people", 34);
//		Person people2 = new Person("people2id", "people2", 50);
//		Person people3 = new Person("people3id", "people3", 17);

		// 將設定好的值放入名為PersonList清單裡

		List<Person> PersonList = new ArrayList<>(); // List<Person> 回傳型態(結果要符合型態)
		PersonList = personDao.findAll(); // 將personDao.findAll()存入PersonList裡

//		PersonList.add(people);
//		PersonList.add(people2);
//		PersonList.add(people3);
		// 最後回傳給PersonList --> List<Person> getPonersonInfo()

		return PersonList; // 因為是要列出所有人的資訊 所以回傳PersonList，而不是回傳類別的Person(只能取得一個人的資訊)
	}

	@Override
	public Person getPersonInfoById(String id) {
		// 設定所有person的值
//		Person people = new Person("peopleid", "people", 34); // Json使用者是輸入String的那個位置內容
//		Person people2 = new Person("people2id", "people2", 50);
//		Person people3 = new Person("people3id", "people3", 17);
//		List<Person> personList = new ArrayList<>();       //空的PersonList陣列清單
//		personList = personDao.findAll();                  //放入資料庫表的欄位及資料

		/*
		 * 方法1 Person person = new Person(); //將Person類別東西放進person這個空間 person =
		 * personDao.findById(id).get(); // person.setId(personDao.getById(id).getId());
		 * 
		 * return person;
		 */

		/// ========================方法2==============================
		// Optional:在jpa中，通常使用在只有單一物件時封裝；只有兩種狀態，有值或沒值，可用來代替null//
//				Optional<Person> PersonOp = personDao.findById(id);
//				if(PersonOp.isPresent()) {          //isPresent:判定是否有東西(值)，有:true
//					Person per = PersonOp.get();
//					System.out.println(per.getId());
//					System.out.println(per.getAge());
//					return PersonOp.get();
//				}else {
//					return new Person();
//				}
		/// ========================方法3==============================
//				Optional<Person> PersonOp = personDao.findById(id);
//				return personDao.findById(id).orElse(new Person());
		/// ========================方法4==============================
		Optional<Person> PersonOp = personDao.findById(id);
		return PersonOp.orElse(new Person()); // .orElse():先用isPresent()確認有無值，如果有返回值.get();
												// 否則(如果沒有)返回.orElse()中的值
		// 一個個比對
//		if (id.equalsIgnoreCase(people.getId())) {
//			return people;
//		}
//		if (id.equalsIgnoreCase(people2.getId())) {
//			return people2;
//		}
//		if (id.equalsIgnoreCase(people3.getId())) {
//			return people3;
//		} else {                                        // id比對失敗就回傳空的Person
//		return new Person();
//		}
	}

//
	@Override
	public List<Person> getPonersonInfoByAgeLargerThan(int age) {
		/*
		 * // 設定所有person的值，個別存放在Person Class 
		 * Person people = new Person("peopleid", "people", 34); 
		 * Person people2 = new Person("people2id", "people2", 50);
		 * Person people3 = new Person("people3id", "people3", 17);
		 * 
		 * // 將設定好的值放入名為PersonList清單裡(預設的Person資訊) 放入一個陣列裡(三個儲存格) 
		 * List<Person>PersonList = new ArrayList<>(); 
		 * PersonList.add(people);
		 * PersonList.add(people2);
		 *  PersonList.add(people3);
		 * 
		 * // -------------------------------------- // 
		 ageList 為存放符合條件(比年齡大)的Person資訊
		 List<Person> ageList = new ArrayList<>(); 
		 for (Person bigageList :PersonList) {
		  	if (age < bigageList.getAge()) {        //判斷使用者輸入的年齡是否有小於person所設置的所有人的年齡
		 		Person personage = new Person(); 
		 		personage.setId(bigageList.getId()); 
		 		personage.setName(bigageList.getName()); 
		 		personage.setAge(bigageList.getAge()); ageList.add(bigageList); 
		  		return ageList;
		  	} 
		  }
		 */

		/*
		 連接DB方法1
		  List<Person> get = new ArrayList<>(); 
		  get = personDao.findAll();
		  
		 List<Person> per = new ArrayList<>();
		 
		 for(Person find : get) {                       //比對結果符合者就會存到per，由於我們就是要列印出符合的那多筆資料 
		 if(age < find.getAge() ) { per.add(find);     //所以才要回傳它
		   return per;
		   }
		 }
		 */
		// =========方法2
		List<Person> list = personDao.findByAgeGreaterThan(age); // findByAgeGreaterThan等同算式
		return list;
	}

	// DB連接 第四題 姓名跟年齡一樣
	@Override
	public List<Person> findByNameAndAge(String name, int age) {
		List<Person> personnameandage = personDao.findByNameAndAge(name, age);
		return personnameandage;
	}

	// DB連接 第五題 姓名一樣 年齡大於年齡
	@Override
	public List<Person> findByNameAndAgeGreaterThan(String name, int age) {
		List<Person> personnameandagegreaterthan = personDao.findByNameAndAgeGreaterThan(name, age);
		return personnameandagegreaterthan;

	}

}
