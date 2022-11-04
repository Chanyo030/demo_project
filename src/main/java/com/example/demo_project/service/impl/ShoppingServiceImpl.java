package com.example.demo_project.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo_project.entity.Product;
import com.example.demo_project.service.ifs.ShoppingService;

@Service
public class ShoppingServiceImpl implements ShoppingService {
	@Override
	public void queryProduct(List<String> nameList, List<Product> productList) {
		for (String str : nameList) {
			int a = 0;
			for (Product product : productList) {
				if (product.getName().equals(str)) {
					a = +1;
					System.out.println("�ӫ~ :" + product.getName() + " ���� :" + product.getPrice() + " �w�s : "
							+ product.getStorage());
					break;
				}
			}
			if (a == 0) {
				System.out.println(str + "�d�L���G");
			}
		}
	}

	public void checkout(List<Product> productList) {
//		productList.get(0).getName();
//		System.out.println(productList.get(0).getName());
//		System.out.println(productList.get(0).getPrice());
//		System.out.println(productList.get(0).getQuantitly());
//		System.out.println((productList.get(0).getPrice())*(productList.get(0).getQuantitly()));
//		System.out.println("=============================");
//		productList.get(1).getName();
//		System.out.println(productList.get(1).getName());
//		System.out.println(productList.get(1).getPrice());
//		System.out.println(productList.get(1).getQuantitly());
//		System.out.println((productList.get(1).getPrice())*(productList.get(1).getQuantitly()));
		System.out.println("=============================");
		Product.setMyMoney(3000);
		int sum=0;
		for (Product checkout : productList) {
			System.out.println(checkout.getName()+ " : " + "�ʶR" + checkout.getQuantitly() + "�] "
					+ checkout.getPrice() * checkout.getQuantitly() + "��");
			System.out.println("�Ѿl����:" + (Product.getMyMoney() - checkout.getPrice()* checkout.getQuantitly()));
			Product.setMyMoney((Product.getMyMoney() - checkout.getPrice()* checkout.getQuantitly()));
			 sum = sum + (checkout.getPrice()* checkout.getQuantitly()); //500
			
		}
		System.out.println("�ʪ��`���B:" + sum);
		
		for(Product checkout : productList) {
			System.out.println("�ӫ~:" + checkout.getName() + " ��~���`����:" + (checkout.getPrice() * checkout.getQuantitly()) + " �Ѿl���w�s�q:" + (checkout.getStorage() - checkout.getQuantitly()));
		}
	}

}
