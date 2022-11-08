package com.eidiko.spring;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eidiko.spring.dao.UserRepo;
import com.eidiko.spring.entity.User;

@SpringBootApplication
public class SpringSecurityJwtApplication {
	//Below code is used to save one record into USER_TBL. @Postconstruct will automatically executes after application is initialized.
//	@Autowired
//	UserRepo userRepo;
//	
//	@PostConstruct
//	public void initUsers() {
//		List<User> users = Stream.of(new User(1,"soumya", "soumya_p","soumya_1@gmail.com")).collect(Collectors.toList());
//		userRepo.saveAll(users);
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

}
