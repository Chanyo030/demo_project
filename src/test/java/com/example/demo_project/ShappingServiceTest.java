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
		List<Product> productList = new ArrayList<>(); // �Ф@�Ӥ������ת�productList�}�C�M��
		Product product = new Product("cookie", 100, 10); // �]�mProduct���O�Ѽ� �ᤩ��product��
		Product product2 = new Product("candy", 200, 20); // �]�mProduct���O�Ѽ� �ᤩ��product��		
		product.setQuantitly(5);
		product2.setQuantitly(10);
		productList.add(product);  						// �a�JproductList�}�C�M�檺��l��
		productList.add(product2);                      // �a�JproductList�}�C�M�檺��l��

		List<String> nameList = new ArrayList<>(); // �]�ߤ@�ӦW��nameList���r���ݩʰ}�C�M�� //�Nabc�o�ӰѼ� �ᤩ��String name��
		nameList.add("cookie");
		nameList.add("candy");

		shoppingService.queryProduct(nameList, productList);
		shoppingService.checkout(productList);
	}
	
	
	
}
