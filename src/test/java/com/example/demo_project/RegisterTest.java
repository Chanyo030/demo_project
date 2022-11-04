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

//=======�椸����=======
@WebAppConfiguration  //�n�ϥ� web ���Ҽ�������

//���F���SpringBootApplication�D�t�m���O�ӱҰ�SpringBoot���ε{������
//�Y��@Autowired��{�����ۭq�q��Dao�BService�������A�@�w�n�[�A�קK@Autowired������null
//======================

@SpringBootTest(classes = DemoProjectApplication.class)    //classes =��񪺬O --> �M�ש��UApplication���W��

//=======�椸����=======
@TestInstance(Lifecycle.PER_CLASS)   //���F��ϥ�@BeforeAll��@AfterAll
//======================

public class RegisterTest {
	
	//=======�椸����=======
	//mockMvc�O���WebAppConfiguration�ҫإߪ�����A�i�H�Ψӽs�gweb���Ϊ���X����
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;  //��{��http�ШD�������A�D�n�ΨӴ���Controller
	
	private static final String CONTENT_TYPE = "application/json;charste = UTF-8";  //���`�ƦV(static final)�A�t�~�N���w�q��charste = UTF-8
	@Autowired
	private WidgetDao widgetDao;
	//======================
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private RegisterDao registerDao;
	
	//=======�椸����=======
	@BeforeAll     //�b�i�J "�Ҧ�" @Test�� '�e' ����  !!!�u�|����@��!!!
	private void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();   //��᭱����F�� �뵹mockMvc
	}
	
	@BeforeEach   //�b�i�J "�C�@��" @Test�� '�e' ���|����@��
	private void beforeEach() {
		System.out.println("Before Each!!");
	}
	
	@AfterAll     //�b "�Ҧ�" @Test ������ '��' ����  !!!�u�|����@��!!!
	private void afterAll() {
		System.out.println("After All!!");
	}
	//====================
	
	//===========�椸���� - �� MockMvc ��{ Http �ШD������1============================
	@SuppressWarnings("unchecked")     //���óo�Ӱ϶��Ҧ������L�C
	@Test
	public void registerControllerTest() throws Exception {
		//�p�G Headers �n�[���ѼƦ��h�ӡA�i�ϥΦ��覡�F
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		//set request_body
		Map<String,Object> map  = new LinkedHashMap<>();  //LinkedHashMap�����i�H�s���춶��
		map.put("account", "A99");
		map.put("pwd", "A123456");
		map.put("name", "David");
		map.put("age", 22);
		map.put("city", "Tainan");
		
		//Map to String
		ObjectMapper objectMapper = new ObjectMapper();          //��map�ন�r�ꪺ�u��(ObjectMapper�O�H�g����k)
		String mapString = objectMapper.writeValueAsString(map);  //��map�নmapString�r��
		
		//���~�g�k  ???�����򤣯�o�˼g???
//		System.out.println(map.toString());
		//�L�X�����G  {account=A99, pwd=A123456, name=David, age=22, city=Tainan}
//		System.out.println(mapString);
		//�L�X�����G {"account":"A99","pwd":"A123456","name":"David","age":22,"city":"Tainan"}
		//postman�榡�p�PMap��Key and Value�A�e�{�覡���O Key = Value (X)�A�ӬO Key : Value (O)
		
		
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/register")
				.contentType(CONTENT_TYPE)  // Headers �n�[���Ѽƥu�� content_type �ɡA�i�����ϥΡA�����z�L Headers �[�J
//	          .headers(headers)  //  �p�Ghead���ݭn�[��L���ѼơA�i�b���[�C      �p�G�o�楴�}�A���W������N���ѱ�(�G��@)
				.content(mapString));
		//Json�榡�զ��p�PMap��key value�CJson key���榡�@�w�O�r��Avalue���@�w(�r��B�Ʀr�B�}�C�B����....)�L�צp�󥦳��O����
		   // ����99�檺Map
		
		//get response && �Nresponse�����e�ন�r��
		String resString = result.andReturn().getResponse().getContentAsString();
		//�N�o�쪺 response �r���ন Json(map)
		JacksonJsonParser jsonparser = new JacksonJsonParser();
		Map<String, Object> resData = jsonparser.parseMap(resString);      //�N�r���নMAP
		String rtnmessage = (String) resData.get("message");
		System.out.println(rtnmessage);
		Assert.isTrue(rtnmessage.equals("Successful"), "Message error!!");
		Map<String,Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A99"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
	}
	//=============�H�W�� �椸���� - �� MockMvc ��{ Http �ШD������======================
	@Test
	public void registerTest() {
		Register reg = registerService.register("A01","123456","Alice", 18, "Tainan");
		Assert.notNull(reg,"Register is null!") ;           //Assert�_�� �ΨӧP�w��or����C����b�P�_reg�O�_��null
		Assert.isTrue(reg.getAccount().equalsIgnoreCase("A01"),"Account erroe");
		registerDao.delete(reg);
		Assert.isTrue(!registerDao.findById("A01").isPresent(),"reg is not null!");
		Assert.isTrue(!registerDao.existsById("A01"),"reg is not null!");   //Assert .IsTrue() ���ի��w������O�_��True�A�p�G��True�A�h���ճq�L
		System.out.println("Register Test!!!");
	}
	
	@Test
	public void activeAccount() {
		//register new account
		Register reg = registerService.register("A01","123456","Alice", 18, "Tainan");  //���U
		Assert.isTrue(!reg.isActive(), "Account is active!!");         //Assert.isTrue�P�_�O�_���u�A�Y���G���p�w��(true)�A�N�|�^�X�᭱��message
//		Assert.isTrue(reg.isActive == false, "Account is active!!");  
		//active registered account
		registerService.activeAccount("A99");                                                     //�E����
		Register newReg = registerDao.findById("A99").get();
		Assert.isTrue(newReg.isActive(), "Account is inactive!!");
//		Assert.isTrue(newReg.isActive == true, "Account is inactive!!");     //reg.isActive() == true -->reg.isActive()
		registerDao.delete(newReg);
		System.out.println("Active Account!!");
	}
	
	//===========�椸���� - �� MockMvc ��{ Http �ШD������2============================
	    @SuppressWarnings("unchecked")
		@Test
		public void activeAccountControllerTest() throws Exception {   //����Controller
			//�p�G Headers �n�[���ѼƦ��h�ӡA�i�ϥΦ��覡�C�ϥήɡA�}��170��A����171��(�]���|�]�t�bheaders�̡A�G�ܤ@)
			HttpHeaders headers =  new HttpHeaders();                  //�NHttpHeaders��J�@�ӥsheaders���Ŷ���
			headers.setContentType(MediaType.APPLICATION_JSON);   //�Nheaders�o�ӰѼ�(�]�m)�ഫ��Json�榡
		                                                                             //����Postment��Headers��ContentType - application/json
		//�ɥRMediaType�G��HTTP ���C�������A�Ω�w�q ��Ʈ榡 (data format)�C
	   //                        Content-Type �]�ݩ�MediaType�C���������@��
			
			//set request_body
			Map<String, Object> map  = new LinkedHashMap<>();   //LinkedHashMap�����i�H�s���춶��
			map.put("account", "A01");
//			map.put("pwd", "A123456");
//			map.put("name", "Alice");
//			map.put("age", 18);
//			map.put("city", "Tainan");
			
			//�z�LObject�NMap�নString
			ObjectMapper objectMapper = new ObjectMapper();
			String mapString = objectMapper.writeValueAsString(map);   //��map��(writeValueAsString)�ন�r��A�H�ŦX191��n�D����ƫ��A(�r��)
			
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/activeAccount")  //���϶��O��postman��
					.contentType(CONTENT_TYPE)     //(CONTENT_TYPE) �o�ӭȬO�w�q�b62��
//					.headers(headers)             //headers �n�[���Ѽƥu��contentType�ɡA�i�����ϥΡA�����z�Lheaders�[�J
					.content(mapString));    //("")�O��body�̪���T�Ccontent�u���\�r��A�ҥH�n��r��C
			//Json�榡�զ��p�PMap��key value�CJson key���榡�@�w�O�r��Avalue���@�w(�r��B�Ʀr�B�}�C�B����....)�L�צp�󥦳��O����
			   // ����178�檺Map
			
			//get response && �Nresponse �����e�ন String  ------------------------ ��
			String resString = result.andReturn().getResponse().getContentAsString();  //	�ҥH�e������ƫ��A�]�n�]���r��
//			MockHttpServletResponse httpRespons = result.andReturn().getResponse();
//			String resString = httpRespons.getContentAsString();
		 
		//�N�o�쪺 response �r���নJson / Map   !!!�p�P192�ɥR�� "Json�榡�զ��p�PMap��key value" !!!
		JacksonJsonParser jsonparser = new JacksonJsonParser();  //�Q�� "JacksonJsonParser" �u�����
		Map<String, Object> resData = jsonparser.parseMap(resString);  //��ƫ��A�]�m�GMap<String,Object>���쥻��Map���A
		String rtnMessage =  (String) resData.get("message");  //String�G����bRegister����message�O�]�w���r��
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Mesage error!!");  //����h���("Successful")�A�]���r�ꥻ���O����
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");  //register��Map�A�]���N����^Map
		
		//�૬�ΧP�_ --> �qMap�̨��oaccount������value�A�Ӥ��O�_����A92(178��)�C(String)�G�N�����ন�r��
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A92"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
		
		}
		//===========�H�W���椸���� - �� MockMvc ��{ Http �ШD������2======================
	    
	    
	    
	  //===========�椸���� - �� MockMvc ��{ Http �ШD������3============================
		@SuppressWarnings("unchecked")
		@Test
		public void addRoleListControllerTest() throws Exception {   //����Controller
			//�p�G Headers �n�[���ѼƦ��h�ӡA�i�ϥΦ��覡�C�ϥήɡA�}��170��A����171��(�]���|�]�t�bheaders�̡A�G�ܤ@)
			HttpHeaders headers =  new HttpHeaders();                  //�NHttpHeaders��J�@�ӥsheaders���Ŷ���
			headers.setContentType(MediaType.APPLICATION_JSON);   //�Nheaders�o�ӰѼ�(�]�m)�ഫ��Json�榡
		                                                                             //����Postment��Headers��ContentType - application/json
		//�ɥRMediaType�G��HTTP ���C�������A�Ω�w�q ��Ʈ榡 (data format)�C
	   //                        Content-Type �]�ݩ�MediaType�C���������@��
			
			//set request_body
			Map<String, Object> map  = new LinkedHashMap<>();   //LinkedHashMap�����i�H�s���춶��
			List<String> roleList = new ArrayList<>();
			roleList.add("AAA");
			roleList.add("BBB");
			map.put("account", "people");
			map.put("roleList", roleList);   //roleList�OAddRoleListReqa���ۭq�q�W��
			
			//�z�LObject�NMap�নString
			ObjectMapper objectMapper = new ObjectMapper();
			String mapString = objectMapper.writeValueAsString(map);   //��map��(writeValueAsString)�ন�r��A�H�ŦX191��n�D����ƫ��A(�r��)
			
			ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/api/add_role_list")  //���϶��O��postman��
					.contentType(CONTENT_TYPE)    
					.content(mapString));
			
			//get response && �Nresponse �����e�ন String  ------------------------ ��
			String resString = result.andReturn().getResponse().getContentAsString(); 

		//�N�o�쪺 response �r���নJson / Map   !!!�p�P192�ɥR�� "Json�榡�զ��p�PMap��key value" !!!
		JacksonJsonParser jsonparser = new JacksonJsonParser();  //�Q�� "JacksonJsonParser" �u�����
		Map<String, Object> resData = jsonparser.parseMap(resString);  //��ƫ��A�]�m�GMap<String,Object>���쥻��Map���A
		String rtnMessage =  (String) resData.get("message");  //String�G����bRegister����message�O�]�w���r��
		System.out.println(rtnMessage);
		Assert.isTrue(rtnMessage.equals("Successful"), "Mesage error!!");  //����h���("Successful")�A�]���r�ꥻ���O����
		Map<String, Object> rtnInfo = (Map<String, Object>) resData.get("register_Info");  //register��Map�A�]���N����^Map
		//�૬�ΧP�_ --> �qMap�̨��oaccount������value�A�Ӥ��O�_����A92(178��)�C(String)�G�N�����ন�r��
		Assert.isTrue(((String)rtnInfo.get("account")).equals("A01"), "Account error!!");
		System.out.println(rtnInfo);
		System.out.println(resData);
		}
	  //===========�H�W���椸���� - �� MockMvc ��{ Http �ШD������3======================
	
	@Test
	public void addRoleTest() {
		List<String> roleList = new ArrayList<>();
		roleList.add("SA");
		roleList.add("SD");
		roleList.add("SA");
		roleList.add("SD");
//		Set<String> set = new HashSet<>();       //�h������
//		for(String item:roleList) {
//			set.add(item);
//			System.out.println(set);
//		}
		registerService.addRole("A02", roleList);
		System.out.println("Add Role Test!!");
	}
	
}
