package com.rabbitemail.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rabbitemail.dto.OrderEvent;

@Service
public class OrderConsumer {

	

    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    
    /*
     * This meathods need to subscribe to queue so  @RabbitListener is use 
     * queues = "${rabbitmq.queue.email.name}:this consume meathod susbscribe to this queue in order to consume event
     * from this perticular queue
     */
    @RabbitListener(queues = "${rabbitmq.queue.email.name}")
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received in email service => %s", event.toString()));
        
        
        //at end email service to email customer
	
	
	
	
	
}
    
}
