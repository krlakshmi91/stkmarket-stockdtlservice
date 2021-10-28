package com.stkmrkt.stockdetails.service;

import com.stkmrkt.stockdetails.model.StockDetailRequest;
import com.stkmrkt.stockdetails.model.StockDetailResponse;

public interface StockDetailService {

	public StockDetailResponse saveCompanyStock(StockDetailRequest request);

	public StockDetailResponse deleteCompanyStock(String companyCde);

	public StockDetailResponse deleteStockById(String stockId);

	public StockDetailResponse getAllStocks();

	public StockDetailResponse getStockById(String stockId);

	public StockDetailResponse getStocksByCompanyCode(String companyCde);

	public StockDetailResponse getStockByRange(String companyCde, String startDate, String endDate);

	public StockDetailResponse getAllLatestStocks();

	public StockDetailResponse getLatestStocksByCompanyCode(String companycde);

}
