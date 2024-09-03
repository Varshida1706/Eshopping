package com.example.demo.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Product;

public interface IProductRepo extends MongoRepository<Product, String>{

	
}
