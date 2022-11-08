package com.eidiko.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eidiko.spring.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	User findByUserName(String userName);

}
