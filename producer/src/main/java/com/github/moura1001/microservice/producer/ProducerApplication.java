package com.github.moura1001.microservice.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.moura1001.microservice.producer.service.ProducerService;

@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {
	
	@Autowired
	private ProducerService service;

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		service.sendMessage("Rabbit message");
	}

}
