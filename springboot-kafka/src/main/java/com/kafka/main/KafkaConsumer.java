package com.kafka.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	//annotations helps to subscribe to the topic
	//when a consumer subscribe to javaguides topic this meathod will work
	@KafkaListener(topics = "javaguides", groupId = "myGroup")
	public void consume(String message) {
		LOGGER.info(String.format("user received by these -> %s", message));
	}
	
}
