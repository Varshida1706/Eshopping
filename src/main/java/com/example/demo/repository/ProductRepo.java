package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public class ProductRepo {
	final Map<Integer,Product> m=new HashMap();
	
	public ProductRepo() {
		m.put(1,new Product(1,"Apple",100));
		m.put(2,new Product(2,"Orange",200));
		m.put(3,new Product(3,"PineApple",300));
		m.put(4,new Product(4,"Guava",400));
		m.put(5,new Product(5,"Banana",50));		
	}
	
	public Product getProduct(int ID)
	{
		return m.get(ID);
	}
	
	public Product getProduct(String Name)
	{
		
		System.out.println("repo name rcvd : "+Name);
		/*
		 * for(int i=1;i<m.size();i++) { System.out.println(m.get(i));
		 * if(m.get(i).getName() == Name); return m.get(i); }
		 */
		for (Product product : m.values()) {
			 System.out.println("Product in map: " + product);
			if(product.getName().equals(Name)) {
				return product;
			}
		}
		
		return null;
	}
	
	public Product addProduct(int id, String name, int price) {
	    System.out.println("inside repo to add/update product");
	    Product existingProduct = m.get(id);
	    if (existingProduct != null) {
	        // Update existing product
	        existingProduct.setName(name);
	        existingProduct.setPrice(price);
	    } else {
	        // Add new product
	        existingProduct = new Product(id, name, price);
	        m.put(id, existingProduct);
	    }
	    return existingProduct; // Return the product (updated or newly added)
	}


	

}
