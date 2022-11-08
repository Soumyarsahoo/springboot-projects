package com.eidiko.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eidiko.spring.dao.UserRepo;
import com.eidiko.spring.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public User saveUser(User user) {
		return userRepo.save(user);
	}
}
