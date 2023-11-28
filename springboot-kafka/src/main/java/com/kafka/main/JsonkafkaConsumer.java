package com.kafka.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.payload.User;

@Service
/*
 *meathod kafkaConsumer to consume a Json Message 
 */
public class JsonkafkaConsumer {

	private static final Logger  LOGGER =LoggerFactory.getLogger(JsonkafkaConsumer.class);
	
	/*
	 * This JsonDeserializer will convert Json into user object
	 */
	
	
	@KafkaListener(topics = "javaguides_json", groupId="myGroup")
	public void consume(User user) {
	
		LOGGER.info(String.format("Json Message recieved -> %s", user.toString()));
	}
	
	
}
