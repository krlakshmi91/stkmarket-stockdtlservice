package com.stkmrkt.stockdetails.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stkmrkt.stockdetails.util.StockServiceEntityMapper;

@Configuration
public class StockDetailConfig {
	
	@Bean
	public StockServiceEntityMapper stockServiceEntityMapper() {
		return new StockServiceEntityMapper();
	}

}
