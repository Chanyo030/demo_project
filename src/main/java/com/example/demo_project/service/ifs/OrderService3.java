package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Menu3;
import com.example.demo_project.vo.MenuReq3;
import com.example.demo_project.vo.MenuRes3;

public interface OrderService3 {
	public MenuRes3 addfood(String name,int price);                     //新增餐點品項
	public List <Menu3> getMenu ();                                          //取得"所有"餐點品項及價格
	public MenuRes3 getOnlyoneFood (String name);                     //取得"單一"餐點品項及價格
	public MenuRes3 order(List<MenuReq3> mreq );                      //點餐、份量及計算總金額
}
