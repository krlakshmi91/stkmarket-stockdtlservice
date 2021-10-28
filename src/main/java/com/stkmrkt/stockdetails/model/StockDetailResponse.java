package com.stkmrkt.stockdetails.model;

import java.util.List;

import com.stkmrkt.stockdetails.entity.StockDetailEntity;

import lombok.Data;

@Data
public class StockDetailResponse extends SuccessResponse {

	private String id;
	private List<StockDetailEntity> stockDetails;
	private StockDetailEntity stockDetail;
	
}
