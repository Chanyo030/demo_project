package com.example.demo_project.constants;

public enum RegisterRtnCode {     //�u�|�Ψ�get �Τ���set
	
	//�W�٦ۨ�  (code , message)
	SUCCESSFUL ("200", "Successful"),   //Successful ���\    �Ĥ@�Ӥ@�w�O���\�A�`�N�g�k
	ACCOUNT_REQUIRED ("400","Account is required!!!"),
	ACCOUNT_EXISTED ("403","Account existed!"),    //403�T��  401�����v
	PWD_REQUIRED ("400","Pwd is required!"),           //400�Ѽƿ��~
	NAME_REQUIRED ("400","Name is required!!!"),
	FAILURE ("500", "Account active is fail! "),
	ADD_ROLE_FAILURE("500","Add role fail"),     //�s�W���⥢��
	ROLE_LIST_IS_EMPTY("400","List is empty");
	
	
	private String code;                  //��6��("200", "Successful")��̬��r��A�ҥH�]�w�{String
	private String message;
	
	private RegisterRtnCode (String code, String message) {         // ���غc��k�O�Φb 6-12��A�Ӧ���k�u���\private
		this.code = code;                                                     //�L�Ѽƫغc��k�Τ��� ���μg
		this.message =message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
	
}
