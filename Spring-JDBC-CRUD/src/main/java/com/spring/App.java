package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.Business.ProductBusiness;
import com.spring.Business.ProductBusinessImpl;
import com.spring.Pojo.Product;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.xml");
		ProductBusiness pbusiness = (ProductBusinessImpl) context.getBean("productBusiness");

		////// insert ////
		/*
		 * Product p=new Product(3,"fan",15000,"kurnool"); pbusiness.saveProduct(p);
		 * System.out.println("Successfully inserted");
		 */

		///// update ////
		/*
		 * Product p=new Product(); p.setId(3); p.setName("bottle"); p.setCost(560);
		 * 
		 * pbusiness.updateProduct(p); System.out.println("Updated Successfully");
		 */

		//// delete ////
		/*
		 * pbusiness.deleteProduct(3); System.out.println("Deleted Successfully");
		 */

		//// getting one id ///
		/*
		 * Product pid=pbusiness.findProductsById(2);
		 * System.out.println("Product:"+pid);
		 */

		//// getting all values ////
		List<Product> pall = pbusiness.findAllProducts();
		System.out.println("All Products:" + pall);
		;
	}
}
