package com.rabbit.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class RabbitMQConfig {
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	
	@Value("${rabbitmq.queue.json.name}")
	private String jsonQueue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	
	@Value("${rabbitmq.routing.json.key}")
	private String routingJsonKey;
	
	//spring bean for rabbitMQ
	@Bean
	public Queue queue() {
		return new Queue(queue);
	}
	
	// spring bean for queue (store json messages)
    @Bean
    public Queue jsonQueue(){
        return new Queue(jsonQueue);
    }
	
	//spring bean for exchnage
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(exchange);
	}
	
	//bind this queue to exchange using key
	@Bean
	public Binding binding() {
	        return BindingBuilder
	                .bind(queue())
	                .to(exchange())
	                .with(routingKey);
	    }
	
	

	//bind this json queue to exchange using key
	@Bean
	public Binding jsonBinding() {
	        return BindingBuilder
	                .bind(jsonQueue())
	                .to(exchange())
	                .with(routingJsonKey);
	    }
	
	/*
	 * meathod for convertor  json o to rabbitTemplate
	 * convert the java object ti json
	 */
	  @Bean
	    public MessageConverter converter(){
	        return new Jackson2JsonMessageConverter();
	    }
	  
	 /*
	  * Amqp template is interface and RabbitMq is class and it implements 
	  *ConnectionFactory is a constructor aRgument 
	  */
	

	    @Bean
	    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
	    }
	  
	  
	  
	
	/*
	 * flow:
	 * connectionFactory
	 * RabbitTemplate
	 * RabbitAdmin
	 */
	
	
	

}
