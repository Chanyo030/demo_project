package com.example.demo_project.constants;

public enum RegisterRtnCode {     //只會用到get 用不到set
	
	//名稱自取  (code , message)
	SUCCESSFUL ("200", "Successful"),   //Successful 成功    第一個一定是成功，注意寫法
	ACCOUNT_REQUIRED ("400","Account is required!!!"),
	ACCOUNT_EXISTED ("403","Account existed!"),    //403禁止  401未授權
	PWD_REQUIRED ("400","Pwd is required!"),           //400參數錯誤
	NAME_REQUIRED ("400","Name is required!!!"),
	FAILURE ("500", "Account active is fail! "),
	ADD_ROLE_FAILURE("500","Add role fail"),     //新增角色失敗
	ROLE_LIST_IS_EMPTY("400","List is empty");
	
	
	private String code;                  //第6行("200", "Successful")兩者為字串，所以設定程String
	private String message;
	
	private RegisterRtnCode (String code, String message) {         // 此建構方法是用在 6-12行，而此方法只允許private
		this.code = code;                                                     //無參數建構方法用不到 不用寫
		this.message =message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
