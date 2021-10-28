package com.stkmrkt.stockdetails.util;

import java.util.Date;

import com.stkmrkt.stockdetails.entity.StockDetailEntity;
import com.stkmrkt.stockdetails.model.StockDetailRequest;

public class StockServiceEntityMapper {

	public StockDetailEntity stockDetailsRequestMapper(StockDetailRequest request) {
		StockDetailEntity entity = new StockDetailEntity();
		entity.setCompanyCode(request.getCompanyCode());
		entity.setStockPrice(request.getStockPrice());
		entity.setStockUpdtTms(new Date());
		return entity;
	}
}
