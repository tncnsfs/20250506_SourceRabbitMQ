package com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.example.model.User;

import lombok.RequiredArgsConstructor;

@Component
public class RabbitSender {
	
	private final RabbitTemplate rabbitTemplate ;
	
    public RabbitSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendUser(User user) {
        rabbitTemplate.convertAndSend("user.exchange", "user.routingkey", user);
    }

}
