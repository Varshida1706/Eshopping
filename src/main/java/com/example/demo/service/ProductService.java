package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IProductRepo;
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
	private  IProductRepo ipd;
	
	/*
	 * public ProductService(ProductRepo pdRepo) { this.pdRepo=pdRepo; }
	 */
	@Autowired
	public void setProductService(ProductRepo pdRepo,IProductRepo ipd) {
		this.pdRepo=pdRepo;
		this.ipd=ipd;
		}
	 
		/*
		 * @Override public Product addProductInMongo(int id, String name, int price) {
		 * String stringId = String.valueOf(id);
		 * 
		 * // Check if the product already exists in the database Product product =
		 * ipd.findById(stringId).orElse(null);
		 * 
		 * if (product == null) { // If the product does not exist, create a new one
		 * product = new Product(id, name, price); } else { // If the product exists,
		 * update its details product.setName(name); product.setPrice(price); }
		 * 
		 * // Save the product back to the database (for both new and updated products)
		 * System.out.println("Saving product to MongoDB: " + product); product =
		 * ipd.save(product); System.out.println("Product saved successfully: " +
		 * product);
		 * 
		 * return product; }
		 */
	
	
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

	@Override
	public Product addProd(int id, String Name, int price) {
		
		Product pd=pdRepo.addProductInMongo(id, Name, price);
		// TODO Auto-generated method stub
		return pd;
	}
	

}
