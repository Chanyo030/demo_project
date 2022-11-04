package com.example.demo_project;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@SpringBootTest
public class ShappingServiceTest {
	@Autowired
	ShoppingService shoppingService;

	@Test
	public void test() {
		List<Product> productList = new ArrayList<>(); // 創一個不限長度的productList陣列清單
		Product product = new Product("cookie", 100, 10); // 設置Product類別參數 賦予給product裡
		Product product2 = new Product("candy", 200, 20); // 設置Product類別參數 賦予給product裡		
		product.setQuantitly(5);
		product2.setQuantitly(10);
		productList.add(product);  						// 帶入productList陣列清單的格子裡
		productList.add(product2);                      // 帶入productList陣列清單的格子裡

		List<String> nameList = new ArrayList<>(); // 設立一個名為nameList的字串屬性陣列清單 //將abc這個參數 賦予給String name裡
		nameList.add("cookie");
		nameList.add("candy");

		shoppingService.queryProduct(nameList, productList);
		shoppingService.checkout(productList);
	}
	
	
	
}
