package com.example.demo.interfaces;

import org.bson.BsonObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.User;

public interface IUserRepo extends MongoRepository<User, Integer> {

}
