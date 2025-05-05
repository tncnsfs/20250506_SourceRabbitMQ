package com.example.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter messageConverter) {
        
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(messageConverter);
        return factory;
    }
	
	
	public static final String EXCHANGE = "user.exchange";
	public static final String QUEUE = "user.queue";
	public static final String QUEUE1 = "user.userQueue";
	public static final String QUEUE2 = "user.userQueue2";
	public static final String ROUTING_KEY = "user.routingkey";

	
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE , false);
	}
	
	@Bean
	public Queue queue1() {
		return new Queue(QUEUE1 , false);
	}
	
	
	@Bean
	public Queue queue2() {
		return new Queue(QUEUE2 , false);
	}
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(EXCHANGE);
	}
	
	@Bean
	public Binding binding(Queue queue , DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	
	
	
}
