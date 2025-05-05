package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService_mq;

@RestController
@RequestMapping("/api/users_mq")
public class UserController_mq {
	
	private final UserService_mq userServicemq ; 
	
	public UserController_mq(UserService_mq userServicemq) {
		this.userServicemq = userServicemq;
	}


	@PostMapping
	public String createUser_mq(@RequestBody User user) {
		userServicemq.insertUser_mq(user);
		return "User inserted and sent to RabbitMQ.";
	}
	
	
}
