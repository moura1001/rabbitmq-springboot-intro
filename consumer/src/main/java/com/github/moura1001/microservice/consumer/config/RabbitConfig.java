package com.github.moura1001.microservice.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.moura1001.microservice.consumer.service.ConsumerService;


@Configuration
public class RabbitConfig {
	
	private static final String QUEUE = "RabbitQueue";
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	@Value("${spring.rabbitmq.username}")
	private String rabbitUser;
	@Value("${spring.rabbitmq.password}")
	private String rabbitPassword;
	
	@Bean
	public Queue rabbitQueue() {
		return new Queue(QUEUE, true);
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
		cachingConnectionFactory.setUsername(rabbitUser);
		cachingConnectionFactory.setPassword(rabbitPassword);
		
		return cachingConnectionFactory;
	}
	
	@Bean
	public MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer messageListener = new SimpleMessageListenerContainer();
		messageListener.setConnectionFactory(connectionFactory());
		messageListener.setQueues(rabbitQueue());
		messageListener.setMessageListener(new ConsumerService());
		
		return messageListener;
	}

}
