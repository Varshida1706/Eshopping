package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.IUserService;
import com.example.demo.model.User;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {
	
	
	@Autowired
	IUserService iuser;
	
	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
	    System.out.println("User data received in API: " + user);
	    
	    User savedUser = iuser.addUser(user);
	    
	    // Prepare a response with user data and a success message
	    Map<String, Object> response = new HashMap<>();
	    response.put("success", true);
	    response.put("message", "User registered successfully");
	    response.put("user", savedUser);  // Include the user object
	    
	    return new ResponseEntity<>(response, HttpStatus.OK);
	} 
	

}
