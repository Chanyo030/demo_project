package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Menu3;
import com.example.demo_project.vo.MenuReq3;
import com.example.demo_project.vo.MenuRes3;

public interface OrderService3 {
	public MenuRes3 addfood(String name,int price);                     //�s�W�\�I�~��
	public List <Menu3> getMenu ();                                          //���o"�Ҧ�"�\�I�~���λ���
	public MenuRes3 getOnlyoneFood (String name);                     //���o"��@"�\�I�~���λ���
	public MenuRes3 order(List<MenuReq3> mreq );                      //�I�\�B���q�έp���`���B
}
