package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPathVariableResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.IProductService;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired	
	IProductService ip;
	@GetMapping("/getProductDetails")   
	public String getProductDetails(@RequestParam("ID") int ID)  // request param is used when variable and value both passed from URI
	{
		String ProductName=ip.getProductDetails(ID);
		return ProductName;

	}
	
	@GetMapping("/getProductDetailsByName/{Name}")
	public String getProductDetailsByName(@PathVariable("Name") String Name) throws Exception // Safer approach - Pathvariable is used when only value is passed from URI
	{
		String ProductName;
		System.out.println(Name);
		if(Name == null) {
			System.out.println("inside if");
			throw new IllegalStateException("Name can not be Null");
		}
		else {
			System.out.println("inside else");
		 ProductName=ip.getProductDetails(Name);
		}
		return ProductName;
	}
	
	@GetMapping("/addProduct/{id}/{name}/{price}")
	public ResponseEntity<Product> addProduct(
			@PathVariable("id") int id,
			@PathVariable("name") String name,
			@PathVariable("price") int price){
		 System.out.println(id + "" + name+""+price);
		 Product product = ip.addProduct(id, name, price);
		 System.out.println("product after adding : " +product);
		
		 if (product != null) {
	            return new ResponseEntity<>(product, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	}
	
	
	@GetMapping("/addUpdateProduct/{id}/{name}/{price}")
	public ResponseEntity<Product> addUpdateProduct(
	        @PathVariable("id") int id,
	        @PathVariable("name") String name,
	        @PathVariable("price") int price) {
	    
	    System.out.println(id + " " + name + " " + price);
	    
	    Product product = ip.addProd(id, name, price);
	    System.out.println("Product after adding/updating: " + product);
	    
	    if (product != null) {
	        return new ResponseEntity<>(product, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	
	@PostMapping("/addProd")
	public ResponseEntity<Product> addProd(@RequestBody Product product){
		
		 System.out.println("Received product data: " + product);
		 Product updatedProduct= ip.addProd(product.getID(), product.getName(), product.getPrice());
		 System.out.println("Product after adding/updating: " + updatedProduct);
		 if (updatedProduct != null) {
		return new ResponseEntity<>(product,HttpStatus.OK);
		 }
		 else {
			 return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@GetMapping("/showProd")
	public ResponseEntity<List<Product>> showProducts(){
		
		List<Product> pd=ip.showProd();
		return new ResponseEntity<List<Product>>(pd,HttpStatus.OK);
	}
	
	
	@GetMapping("/showMyProd")
	public ResponseEntity <Product> showProduct(@RequestBody Product product){
		
		Product pd=ip.showProduct((product.getID()));
		return new ResponseEntity<Product>(pd,HttpStatus.OK);
	}

}
