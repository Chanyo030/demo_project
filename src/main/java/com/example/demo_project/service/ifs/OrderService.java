package com.example.demo_project.service.ifs;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;

@Service
public interface OrderService {
	
	public void addonlyfood (Menu menu);                             //�s�W�è��o��@�~��������
	public int getTotalPrice (Map<Menu,Integer> itemMap);        //���o�\�I�`�����500���E��
	public void printOrder (Map<Menu, Integer> itemMap);        //�L�X�\�I���e + ���q + �ӫ~���`����A�Υ����\�I�`���B

}
