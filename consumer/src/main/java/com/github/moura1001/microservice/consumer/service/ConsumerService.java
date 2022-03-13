package com.github.moura1001.microservice.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class ConsumerService implements MessageListener {
	
	private long consumedMessages = 0;
	
	private final Logger logger = LoggerFactory.getLogger(ConsumerService.class.getName());

	@Override
	public void onMessage(Message message) {
		consumedMessages++;
		String logMessage = String.format("Total consumed ==> %d\n"
									+ "Current message ==> %s",
									consumedMessages, message);
		logger.info(logMessage);
	}

}
