package com.example.demo_project.service.ifs;

import java.util.List;

import com.example.demo_project.entity.Product;

public interface ShoppingService {        //介面 不能放new
	public void queryProduct (List<String> nameList,List<Product> productList);
	public void checkout(List<Product> productList);
}
