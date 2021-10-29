/*package com.stkmrkt.stockdetails.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stkmrkt.stockdetails.configuration.StockServiceMessagingConfig;
import com.stkmrkt.stockdetails.entity.StockDetailEntity;

@Component
public class StockServiceMessagePublisher {

	@Autowired
    private RabbitTemplate template;
	
	public String publishCompanyStockDetails(StockDetailEntity entity) {
        template.convertAndSend(StockServiceMessagingConfig.EXCHANGE, StockServiceMessagingConfig.ROUTING_KEY, entity);
        return "Success !!";
    }
}
*/