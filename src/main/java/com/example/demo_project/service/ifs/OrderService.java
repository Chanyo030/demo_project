package com.example.demo_project.service.ifs;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Menu;

@Service
public interface OrderService {
	
	public void addonlyfood (Menu menu);                             //穝糤眔虫珇兜ぇ基
	public int getTotalPrice (Map<Menu,Integer> itemMap);        //眔繺翴羆基の500ゴч
	public void printOrder (Map<Menu, Integer> itemMap);        //繺翴ず甧 + 秖 + 赣珇兜羆基の场繺翴羆肂

}
