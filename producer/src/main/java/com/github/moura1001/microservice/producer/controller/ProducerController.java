package com.github.moura1001.microservice.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.moura1001.microservice.producer.service.ProducerService;

@RestController
@RequestMapping("/rabbitmq")
public class ProducerController {
	
	@Autowired
	private ProducerService service;
	
	@PostMapping("/send")
	public ResponseEntity<?> sendMessage(@RequestBody String message) {
		service.sendMessage(message);
		
		return ResponseEntity.ok("Message sent to queue successfully.");
	}

}
