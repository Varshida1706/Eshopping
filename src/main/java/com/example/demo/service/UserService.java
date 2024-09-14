package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IUserService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService implements IUserService{
	
	@Autowired
	UserRepo ur;

	@Override
	public User addUser(User userdata) {
		// TODO Auto-generated method stub
		System.out.println("");
		
		User user= ur.addUser(userdata);
		return user;
	}

}
