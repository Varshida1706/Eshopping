package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.interfaces.IUserRepo;
import com.example.demo.model.Product;
import com.example.demo.model.User;

@Repository
public class UserRepo {
	@Autowired
	IUserRepo iuserrepo;
	
	
	
public User addUser(User userdata) {
	    
	  
	    System.out.println("Saving product to MongoDB: " + userdata);
	    User u = iuserrepo.save(userdata);
	    System.out.println("Product saved successfully: " + u);
	    
	    return u;
	}

}
