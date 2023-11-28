package com.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

	//we create kafka topic
	@Bean
	public NewTopic javaguidesTopics() {
		return TopicBuilder.name("javaguides")
				.build();
	}
	
	@Bean
	public NewTopic javaguidesJsonTopics() {
		return TopicBuilder.name("javaguides_json")
				.build();
	}
	
	
	
}
