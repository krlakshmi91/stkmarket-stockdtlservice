package com.stkmrkt.stockdetails.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stkmrkt.stockdetails.configuration.StockServiceMessagingConfig;
import com.stkmrkt.stockdetails.entity.StockDetailEntity;
import com.stkmrkt.stockdetails.repository.StockDetailRepository;

@Component
public class StockServiceMessageListner {

	@Autowired
	StockDetailRepository repository;
	
	//@Scheduled(cron = "* * * * * ?")
	@RabbitListener(queues = StockServiceMessagingConfig.QUEUE)
    public void consumeMessageFromQueue(StockDetailEntity entity) {
        System.out.println("Message recieved from queue : " + entity);
        repository.save(entity);
    }
	
}
