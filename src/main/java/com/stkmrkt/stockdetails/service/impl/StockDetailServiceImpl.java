package com.stkmrkt.stockdetails.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.stkmrkt.stockdetails.entity.StockDetailEntity;
import com.stkmrkt.stockdetails.model.StockDetailRequest;
import com.stkmrkt.stockdetails.model.StockDetailResponse;
import com.stkmrkt.stockdetails.repository.StockDetailRepository;
import com.stkmrkt.stockdetails.service.StockDetailService;
import com.stkmrkt.stockdetails.util.StockServiceEntityMapper;

@Service
public class StockDetailServiceImpl implements StockDetailService {

	@Autowired
	MongoTemplate mongo;
	
	@Autowired
	StockDetailRepository repository;
	
	@Autowired
	StockServiceMessagePublisher publish;
	
	@Autowired
	StockServiceEntityMapper mapper;

	@Override
	public StockDetailResponse saveCompanyStock(StockDetailRequest request) {
		StockDetailEntity entity = mapper.stockDetailsRequestMapper(request);
		publish.publishCompanyStockDetails(entity);
		StockDetailResponse response = new StockDetailResponse();
		//response.setId(result.getId().toString());
		response.setResponseID("123456");
		response.setResponseMsg("Stock saved successfully");
		return response;
	}
	
	@Override
	public StockDetailResponse deleteCompanyStock(String companyCde) {
		Long companyId = Long.valueOf(companyCde);
		repository.deleteByCompanyCode(companyId);
		StockDetailResponse response = new StockDetailResponse();
		response.setResponseID("123456");
		response.setResponseMsg("Stock deleted successfully");
		return response;
	}
	
	@Override
	public StockDetailResponse deleteStockById(String stockId) {
		repository.deleteById(stockId);
		StockDetailResponse response = new StockDetailResponse();
		response.setResponseID("123456");
		response.setResponseMsg("Stock deleted successfully");
		return response;
	}
	
	@Override
	public StockDetailResponse getAllStocks() {
		List<StockDetailEntity> entityList = repository.findAll();
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetails(entityList);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}
	
	@Override
	public StockDetailResponse getStocksByCompanyCode(String companyCode) {
		Long companyId = Long.valueOf(companyCode);
		List<StockDetailEntity> entityList = repository.findStocksByCompanyCode(companyId);
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetails(entityList);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}

	@Override
	public StockDetailResponse getStockById(String stockId) {
		StockDetailEntity entity = repository.findById(stockId)
				.orElseThrow(() -> new RuntimeException());
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetail(entity);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}

	@Override
	public StockDetailResponse getStockByRange(String companyCde, String startDate, String endDate) {
		Long companyId = Long.valueOf(companyCde);
		Date startdate = null;
		Date enddate = null;
		try {
			startdate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
			enddate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
		} catch (Exception e) {
			// do nothing
		}
		List<StockDetailEntity> entityList = repository.findStocksByRange(companyId, startdate, enddate);
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetails(entityList);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}

	@Override
	public StockDetailResponse getAllLatestStocks() {
		List<StockDetailEntity> entityList = repository.findAllLatestStock();
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetails(entityList);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}

	@Override
	public StockDetailResponse getLatestStocksByCompanyCode(String companycde) {
		Long companyId = Long.valueOf(companycde);
		List<StockDetailEntity> entityList = repository.findStocksByCompanyCode(companyId);
		Comparator<StockDetailEntity> comparator = Comparator.comparing(StockDetailEntity::getStockUpdtTms);
		StockDetailEntity stock = entityList.stream().filter(s->s.getStockUpdtTms() != null).max(comparator).get();
		List<StockDetailEntity> list = new ArrayList<>();
		list.add(stock);
		StockDetailResponse response = new StockDetailResponse();
		response.setStockDetails(list);
		response.setResponseID("123456");
		response.setResponseMsg("Fetched Stock successfully");
		return response;
	}
}
