package com.example.service;

import org.springframework.stereotype.Service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.rabbit.RabbitSender;

@Service
public class UserService_mq {
	
	private final UserMapper userMapper;
	private final RabbitSender rabbitSender;

	public UserService_mq(UserMapper userMapper,RabbitSender rabbitSender) {
		this.userMapper = userMapper;
		this.rabbitSender = rabbitSender;
	}
	
	public void insertUser_mq(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser_mq(user);
		rabbitSender.sendUser(user);
	}
	
	public void insertReceiveMap(User user) {
		// TODO Auto-generated method stub
		userMapper.insertUser_mq(user);
	}
	

}
