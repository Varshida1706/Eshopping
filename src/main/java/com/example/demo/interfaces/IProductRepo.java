package com.example.demo.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Product;

public interface IProductRepo extends MongoRepository<Product, Integer>{

	Optional<Product> findByID(Integer ID);
	Optional<Product> findByName(String Name);
	Optional<Product> findByNameAndID(String name, Integer ID);
	
}
