package com.example.demo.interfaces;

import com.example.demo.model.Product;

public interface IProductService {

	public String getProductDetails(int ID);
	public String getProductDetails(String Name);
	public Product addProduct(int id,String Name,int price);
}
