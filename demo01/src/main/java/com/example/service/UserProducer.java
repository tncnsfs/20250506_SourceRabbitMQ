package com.example.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import com.example.modelSe.User;

@Service
public class UserProducer {
	
	private final AmqpTemplate amqpTemplate;
	private final String SENDQUEUE1 = "user.userQueue";
	private final String SENDQUEUE2 = "user.userQueue2";
	
	public UserProducer(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
	
	// sender producer 보내기 
	public void send(String content) {
		System.out.println("ready send : " + content);
		
		amqpTemplate.convertAndSend(SENDQUEUE1,content);
	}
	
	// sender Map producer 보내기 
	public void sendObj(User users) {
		System.out.println( users);
		amqpTemplate.convertAndSend(SENDQUEUE2 ,users);
	}
	
	

}
