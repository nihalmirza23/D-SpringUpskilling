package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.main.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

	@Autowired
	private KafkaProducer kafkaProducer;

	//meathod to read events or message from cmd
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message){
		
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent to the topic");
	}
	
	
	
	
}
