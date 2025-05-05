package com.example.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelSe.User;
import com.example.service.UserProducer;

@RestController
@RequestMapping("/api")
public class UserProducerCrontroller {
	
	private final UserProducer userProducer	 ;
	
	public UserProducerCrontroller(UserProducer userProducer) {
		this.userProducer = userProducer;
	}

	// param1 
	@PostMapping("/send")  
	public String send(@RequestParam String content) {
		System.out.println("ready send content: " + content);
		userProducer.send(content);
		return "Message sent: " + content;
		
	}

	// Body 
	@PostMapping("/sendbody")  
	public String sendobj(@RequestBody User users) {
		System.out.println("ready sendObject users: " + users);
		userProducer.sendObj(users);
		return "Message sent: " + users;
		
	}
	

}
