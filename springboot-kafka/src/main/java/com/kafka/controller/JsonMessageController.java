package com.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.main.JsonKafkaProducer;
import com.kafka.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

	private JsonKafkaProducer KafkaProducer;

	public JsonMessageController(JsonKafkaProducer KafkaProducer) {
		
		this.KafkaProducer = KafkaProducer;
	}
	
	@PostMapping("/publish")
	/*
	 * meathod for kafkaProducer will send a Jsonserializer Message to
	 * kafka Topic
	 */
	
	
	public ResponseEntity<String> publish(@RequestBody   User user){
		
		KafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Message sent to kafka topic");
		
	}
	
	
	
}
