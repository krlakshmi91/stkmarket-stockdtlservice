package com.stkmrkt.stockdetails.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.stkmrkt.stockdetails.entity.StockDetailEntity;

public interface StockDetailRepository extends MongoRepository<StockDetailEntity, String> {

	@Query(value="{'companyCode' : ?0}", delete = true)
	public StockDetailEntity deleteByCompanyCode (Long companyCde);
	
	@Query(value="{'companyCode' : ?0}")
	public List<StockDetailEntity> findStocksByCompanyCode (Long companyCde);
	
	@Query(value="{'companyCode' : ?0}")
	public List<StockDetailEntity> findLatestStocksByCompanyCode (Long companyCde);
	
	@Query(value="{'companyCode' : ?0, 'stockUpdtTms': {$gt: ?1, $lt: ?2 }}")
	public List<StockDetailEntity> findStocksByRange (Long companyCde, Date startDate, Date endDate);
	
	@Query(value="{'companyCode' : ?0}", delete = true)
	public List<StockDetailEntity> findAllLatestStock ();
}
