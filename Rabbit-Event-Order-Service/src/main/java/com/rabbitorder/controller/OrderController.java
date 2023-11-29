package com.rabbitorder.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitorder.dto.Order;
import com.rabbitorder.dto.OrderEvent;
import com.rabbitorder.publisher.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

	 private OrderProducer orderProducer;

	    public OrderController(OrderProducer orderProducer) {
	        this.orderProducer = orderProducer;
	    }

	    @PostMapping("/orders")
	    public String placeOrder(@RequestBody Order order){

	        order.setId(UUID.randomUUID().toString());

	        OrderEvent event = new OrderEvent();
	        event.setStatus("SHOWING PENDINg");
	        event.setMessage("Order is in pending process");
	        event.setOrder(order);

	        orderProducer.sendMessage(event);

	        return "Order sent to the RabbitMQ ..";
	    }
	
}
