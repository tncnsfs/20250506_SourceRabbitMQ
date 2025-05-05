package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.config.RabbitConfig;
import com.example.model.User;
import com.example.service.UserService_mq;

@Component
public class UserConsumer {
	UserService_mq userServiceMq;

	public UserConsumer(UserService_mq userServiceMq) {
		this.userServiceMq = userServiceMq;
	}
	
	
	@RabbitListener(queues = RabbitConfig.QUEUE1)
	public void receiveParam(String content) {
		System.out.println("receive content : "+ content);
		int cnt = 11; 
		User user = new User();
		user.setAge(cnt++);
		user.setContent(content);
		userServiceMq.insertUser_mq(user);
	}
	
	@RabbitListener(queues = RabbitConfig.QUEUE2)
	public void receiveParam(User users) {
		System.out.println("receive user : "+ users);
		
		userServiceMq.insertReceiveMap(users);
	}
	

}
