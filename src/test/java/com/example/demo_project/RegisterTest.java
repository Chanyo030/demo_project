package com.example.demo_project;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

//import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_project.entity.Register;
import com.example.demo_project.repository.RegisterDao;
import com.example.demo_project.repository.WidgetDao;
import com.example.demo_project.service.ifs.RegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;

//=======單元測試=======
@WebAppConfiguration  //要使用 web 環境模擬測試

//為了找到SpringBootApplication主配置類別來啟動SpringBoot應用程式環境
//若有@Autowired到程式中自訂義的Dao、Service等部分，一定要加，避免@Autowired的物件為null
//======================

@SpringBootTest(classes = DemoProjectApplication.class)    //classes =後放的是 --> 專案底下Application的名稱

//=======單元測試=======
@TestInstance(Lifecycle.PER_CLASS)   //為了能使用@BeforeAll及@AfterAll
//======================

public class RegisterTest {
	
	//=======單元測試=======
	//mockMvc是基於WebAppConfiguration所建立的物件，可以用來編寫web應用的整合測試
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;  //實現對http請求的模擬，主要用來測試Controller
	
	private static final String CONTENT_TYPE = "application/json;charste = UTF-8";  //為常數向(static final)，另外將它定義為charste = UTF-8
	@Autowired
	private WidgetDao widgetDao;
	//======================
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterDao registerDao;
	
	//=======單元測試=======
	@BeforeAll     //在進入 "所有" @Test之 '前' 執行  !!!只會執行一次!!!
	private void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //把後面那串東西 塞給mockMvc
	}
	
	@BeforeEach   //在進入 "每一個" @Test之 '前' 都會執行一次
	private void beforeEach() {
		System.out.println("Before Each!!");
	}
	
	@AfterAll     //在 "所有" @Test 結束之 '後' 執行  !!!只會執行一次!!!
	private void afterAll() {
		System.out.println("After All!!");
	}
	//====================
	
	//===========單元測試 - 用 MockMvc 實現 Http 請求的模擬1============================
	@SuppressWarnings("unchecked")     //隱藏這個區塊所有的黃蚯蚓
	@Test
	public void registerControllerTest() throws Exception {
		//如果 Headers 要加的參數有多個，可使用此方式；
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//set request_body
		Map<String,Object> map  = new LinkedHashMap<>();  //LinkedHashMap讓它可以連結到順序
		map.put("account", "A99");
		map.put("pwd", "A123456");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Tainan");
		
		//Map to String
		ObjectMapper objectMapper = new ObjectMapper();          //把map轉成字串的工具(ObjectMapper別人寫的方法)
		String mapString = objectMapper.writeValueAsString(map);  //把map轉成mapString字串
		
		//錯誤寫法  ???為什麼不能這樣寫???
//		System.out.println(map.toString());
		//印出的結果  {account=A99, pwd=A123456, name=David, age=22, city=Tainan}
//		System.out.println(mapString);
		//印出的結果 {"account":"A99","pwd":"A123456","name":"David","age":22,"city":"Tainan"}
		//postman格式如同Map的Key and Value，呈現方式不是 Key = Value (X)，而是 Key : Value (O)
		
		
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
				.contentType(CONTENT_TYPE)  // Headers 要加的參數只有 content_type 時，可直接使用，不須透過 Headers 加入
//	          .headers(headers)  //  如果head有需要加其他的參數，可在此加。      如果這行打開，那上面那行就註解掉(二選一)
				.content(mapString));
		//Json格式組成如同Map的key value。Json key的格式一定是字串，value不一定(字串、數字、陣列、物件....)無論如何它都是物件
		   // 對應99行的Map
		
		//get response && 將response的內容轉成字串
		String resString = result.andReturn().getResponse().getContentAsString();
		//將得到的 response 字串轉成 Json(map)
		JacksonJsonParser jsonparser = new JacksonJsonParser();
		Map<String, Object> resData = jsonparser.parseMap(resString);      //將字串轉成MAP
		String rtnmessage = (String) resData.get("message");
		System.out.println(rtnmessage);
		Assert.isTrue(rtnmessage.equals("Successful"), "Message error!!");
		Map<String,Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A99"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
	}
	//=============以上為 單元測試 - 用 MockMvc 實現 Http 請求的模擬======================
	@Test
	public void registerTest() {
		Register reg = registerService.register("A01","123456","Alice", 18, "Tainan");
		Assert.notNull(reg,"Register is null!") ;           //Assert斷言 用來判定對or不對。此行在判斷reg是否為null
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A01"),"Account erroe");
		registerDao.delete(reg);
		Assert.isTrue(!registerDao.findById("A01").isPresent(),"reg is not null!");
		Assert.isTrue(!registerDao.existsById("A01"),"reg is not null!");   //Assert .IsTrue() 測試指定的條件是否為True，如果為True，則測試通過
		System.out.println("Register Test!!!");
	}
	
	@Test
	public void activeAccount() {
		//register new account
		Register reg = registerService.register("A01","123456","Alice", 18, "Tainan");  //註冊
		Assert.isTrue(!reg.isActive(), "Account is active!!");         //Assert.isTrue判斷是否為真，若結果不如預期(true)，就會回出後面的message
//		Assert.isTrue(reg.isActive == false, "Account is active!!");  
		//active registered account
		registerService.activeAccount("A99");                                                     //激活它
		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive(), "Account is inactive!!");
//		Assert.isTrue(newReg.isActive == true, "Account is inactive!!");     //reg.isActive() == true -->reg.isActive()
		registerDao.delete(newReg);
		System.out.println("Active Account!!");
	}
	
	//===========單元測試 - 用 MockMvc 實現 Http 請求的模擬2============================
	    @SuppressWarnings("unchecked")
		@Test
		public void activeAccountControllerTest() throws Exception {   //測試Controller
			//如果 Headers 要加的參數有多個，可使用此方式。使用時，開啟170行，註解171行(因為會包含在headers裡，二擇一)
			HttpHeaders headers =  new HttpHeaders();                  //將HttpHeaders放入一個叫headers的空間裡
			headers.setContentType(MediaType.APPLICATION_JSON);   //將headers這個參數(設置)轉換成Json格式
		                                                                             //對應Postment裡Headers的ContentType - application/json
		//補充MediaType：為HTTP 的媒體類型，用於定義 資料格式 (data format)。
	   //                        Content-Type 也屬於MediaType媒體類型的一種
			
			//set request_body
			Map<String, Object> map  = new LinkedHashMap<>();   //LinkedHashMap讓它可以連結到順序
			map.put("account", "A01");
//			map.put("pwd", "A123456");
//			map.put("name", "Alice");
//			map.put("age", 18);
//			map.put("city", "Tainan");
			
			//透過Object將Map轉成String
			ObjectMapper objectMapper = new ObjectMapper();
			String mapString = objectMapper.writeValueAsString(map);   //把map值(writeValueAsString)轉成字串，以符合191行要求的資料型態(字串)
			
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/activeAccount")  //此區塊是打postman的
					.contentType(CONTENT_TYPE)     //(CONTENT_TYPE) 這個值是定義在62行
//					.headers(headers)             //headers 要加的參數只有contentType時，可直接使用，不須透過headers加入
					.content(mapString));    //("")是放body裡的資訊。content只允許字串，所以要放字串。
			//Json格式組成如同Map的key value。Json key的格式一定是字串，value不一定(字串、數字、陣列、物件....)無論如何它都是物件
			   // 對應178行的Map
			
			//get response && 將response 的內容轉成 String  ------------------------ ↓
			String resString = result.andReturn().getResponse().getContentAsString();  //	所以前面的資料型態也要設為字串
//			MockHttpServletResponse httpRespons = result.andReturn().getResponse();
//			String resString = httpRespons.getContentAsString();
		 
		//將得到的 response 字串轉成Json / Map   !!!如同192補充的 "Json格式組成如同Map的key value" !!!
		JacksonJsonParser jsonparser = new JacksonJsonParser();  //利用 "JacksonJsonParser" 工具來轉
		Map<String, Object> resData = jsonparser.parseMap(resString);  //資料型態設置：Map<String,Object>為原本的Map型態
		String rtnMessage =  (String) resData.get("message");  //String：原先在Register中的message是設定為字串
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Mesage error!!");  //物件去比對("Successful")，因為字串本身是物件
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");  //register為Map，因此將其轉回Map
		
		//轉型及判斷 --> 從Map裡取得account對應的value，來比對是否等於A92(178行)。(String)：將物件轉成字串
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A92"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
		
		}
		//===========以上為單元測試 - 用 MockMvc 實現 Http 請求的模擬2======================
	    
	    
	    
	  //===========單元測試 - 用 MockMvc 實現 Http 請求的模擬3============================
		@SuppressWarnings("unchecked")
		@Test
		public void addRoleListControllerTest() throws Exception {   //測試Controller
			//如果 Headers 要加的參數有多個，可使用此方式。使用時，開啟170行，註解171行(因為會包含在headers裡，二擇一)
			HttpHeaders headers =  new HttpHeaders();                  //將HttpHeaders放入一個叫headers的空間裡
			headers.setContentType(MediaType.APPLICATION_JSON);   //將headers這個參數(設置)轉換成Json格式
		                                                                             //對應Postment裡Headers的ContentType - application/json
		//補充MediaType：為HTTP 的媒體類型，用於定義 資料格式 (data format)。
	   //                        Content-Type 也屬於MediaType媒體類型的一種
			
			//set request_body
			Map<String, Object> map  = new LinkedHashMap<>();   //LinkedHashMap讓它可以連結到順序
			List<String> roleList = new ArrayList<>();
			roleList.add("AAA");
			roleList.add("BBB");
			map.put("account", "people");
			map.put("roleList", roleList);   //roleList是AddRoleListReqa的自訂義名稱
			
			//透過Object將Map轉成String
			ObjectMapper objectMapper = new ObjectMapper();
			String mapString = objectMapper.writeValueAsString(map);   //把map值(writeValueAsString)轉成字串，以符合191行要求的資料型態(字串)
			
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/add_role_list")  //此區塊是打postman的
					.contentType(CONTENT_TYPE)    
					.content(mapString));
			
			//get response && 將response 的內容轉成 String  ------------------------ ↓
			String resString = result.andReturn().getResponse().getContentAsString(); 

		//將得到的 response 字串轉成Json / Map   !!!如同192補充的 "Json格式組成如同Map的key value" !!!
		JacksonJsonParser jsonparser = new JacksonJsonParser();  //利用 "JacksonJsonParser" 工具來轉
		Map<String, Object> resData = jsonparser.parseMap(resString);  //資料型態設置：Map<String,Object>為原本的Map型態
		String rtnMessage =  (String) resData.get("message");  //String：原先在Register中的message是設定為字串
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Mesage error!!");  //物件去比對("Successful")，因為字串本身是物件
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");  //register為Map，因此將其轉回Map
		//轉型及判斷 --> 從Map裡取得account對應的value，來比對是否等於A92(178行)。(String)：將物件轉成字串
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A01"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
		}
	  //===========以上為單元測試 - 用 MockMvc 實現 Http 請求的模擬3======================
	
	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("SA");
		roleList.add("SD");
//		Set<String> set = new HashSet<>();       //去除重複
//		for(String item:roleList) {
//			set.add(item);
//			System.out.println(set);
//		}
		registerService.addRole("A02", roleList);
		System.out.println("Add Role Test!!");
	}
	
}
