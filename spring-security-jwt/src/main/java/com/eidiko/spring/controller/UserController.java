package com.eidiko.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.spring.entity.AuthRequest;
import com.eidiko.spring.entity.User;
import com.eidiko.spring.service.UserService;
import com.eidiko.spring.util.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	AuthenticationManager authenticationManager;

	@PostMapping("/saveuser")
	public User saveUser(@RequestBody User user) {
		log.info("User -->" + user.getUserName());
		return userService.saveUser(user);
	}

	@GetMapping("/")
	public String hello() {
		return "HELLO";
	}

	@PostMapping("/authenticate")
	public String authenticateUser(@RequestBody AuthRequest authRequest) {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new RuntimeException("Invalid username or password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

}
