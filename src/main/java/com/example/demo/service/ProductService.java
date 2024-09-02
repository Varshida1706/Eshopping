package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IProductService;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;

@Service
public class ProductService implements IProductService{
	
	// ProductRepo pdRepo=new ProductRepo();
	/*
	 * @Autowired ProductRepo pdRepo;
	 */
	
	private  ProductRepo pdRepo;
	
	/*
	 * public ProductService(ProductRepo pdRepo) { this.pdRepo=pdRepo; }
	 */
	@Autowired
	public void setProductService(ProductRepo pdRepo) {
		this.pdRepo=pdRepo;
		}
	 
	
	
	
	
	@Override
	public String getProductDetails(int ID)
	{
		//pdRepo.setProduct();
		return pdRepo.getProduct(ID).toString();
	}
	
	@Override
	public String getProductDetails(String Name)
	{
		//pdRepo.setProduct();
		
		Product pd= pdRepo.getProduct(Name);
		 if (pd != null) {
	            return pd.toString(); // Return the product details if found
	        } else {
	            return "Product not found"; // Handle the case where the product is not found
	        }
	}





	@Override
	public Product addProduct(int id, String Name, int price) {
		// TODO Auto-generated method stub
		 Product product=	pdRepo.addProduct(id, Name, price);
		return product;
		
	}

}
