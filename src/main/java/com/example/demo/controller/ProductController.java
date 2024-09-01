package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	

}
