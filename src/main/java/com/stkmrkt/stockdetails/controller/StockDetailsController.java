package com.stkmrkt.stockdetails.controller;

import static com.stkmrkt.stockdetails.constants.Constants.API_CONTEXT_ROOT;
import static com.stkmrkt.stockdetails.constants.Constants.DELETE_STOCK_BY_CPMYCDE_URI;
import static com.stkmrkt.stockdetails.constants.Constants.DELETE_STOCK_BY_ID_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_ALL_LATEST_STOCK_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_ALL_STOCK_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_LATEST_STOCK_BY_CPMYCDE_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_STOCK_BY_CPMYCDE_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_STOCK_BY_ID_URI;
import static com.stkmrkt.stockdetails.constants.Constants.FETCH_STOCK_BY_RANGE_URI;
import static com.stkmrkt.stockdetails.constants.Constants.SAVE_COMPANY_STOCK_URI;
import static com.stkmrkt.stockdetails.constants.Constants.STOCK_DETAILS_CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stkmrkt.stockdetails.model.StockDetailRequest;
import com.stkmrkt.stockdetails.model.StockDetailResponse;
import com.stkmrkt.stockdetails.service.StockDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = API_CONTEXT_ROOT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = STOCK_DETAILS_CONTROLLER, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class StockDetailsController {

	@Autowired
	StockDetailService service;

	@ApiOperation(value = SAVE_COMPANY_STOCK_URI, notes = "This API is used to save the stock detail of a compnay")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail saved successfully", response = StockDetailResponse.class)})
	@PostMapping(SAVE_COMPANY_STOCK_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> saveCompanyData(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "StockDetailRequest", value = "Request Body", required = true) @RequestBody StockDetailRequest request) {
		log.info("Stock details service started");
		StockDetailResponse response = service.saveCompanyStock(request);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = DELETE_STOCK_BY_CPMYCDE_URI, notes = "This API is used to delete the stock detail of a compnay")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail deleted successfully", response = StockDetailResponse.class) })
	@DeleteMapping(DELETE_STOCK_BY_CPMYCDE_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> deleteCompanyStock(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "companyCode", value = "companyCode", required = true) @PathVariable(name = "companyCode", required = true) String companyCode) {
		log.info("Stock details service started");
		StockDetailResponse response = service.deleteCompanyStock(companyCode);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = DELETE_STOCK_BY_ID_URI, notes = "This API is used to delete the stock detail based on ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail deleted successfully", response = StockDetailResponse.class) })
	@DeleteMapping(DELETE_STOCK_BY_ID_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> deleteStockById(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "stockId", value = "stockId", required = true) @PathVariable(name = "stockId", required = true) String stockId) {
		log.info("Stock details service started");
		StockDetailResponse response = service.deleteStockById(stockId);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = FETCH_STOCK_BY_CPMYCDE_URI, notes = "This API is used to fetch all the stock detail based on company code")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail selected successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_STOCK_BY_CPMYCDE_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getStocksByCompanyCode(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "companyCode", value = "companyCode", required = true) @PathVariable(name = "companyCode", required = true) String companyCode) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getStocksByCompanyCode(companyCode);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = FETCH_LATEST_STOCK_BY_CPMYCDE_URI, notes = "This API is used to fetch all the stock detail based on company code")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail selected successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_LATEST_STOCK_BY_CPMYCDE_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getLatestStocksByCompanyCode(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "companyCode", value = "companyCode", required = true) @PathVariable(name = "companyCode", required = true) String companyCode) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getLatestStocksByCompanyCode(companyCode);
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = FETCH_ALL_STOCK_URI, notes = "This API is used to delete the stock detail based on ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail deleted successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_ALL_STOCK_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getAllStocks(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getAllStocks();
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = FETCH_ALL_LATEST_STOCK_URI, notes = "This API is used to delete the stock detail based on ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail deleted successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_ALL_LATEST_STOCK_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getAllLatestStocks(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getAllLatestStocks();
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = FETCH_STOCK_BY_ID_URI, notes = "This API is used to fetch the stock detail based on ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail selected successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_STOCK_BY_ID_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getStockById(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "stockId", value = "stockId", required = true) @PathVariable(name = "stockId", required = true) String stockId) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getStockById(stockId);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = FETCH_STOCK_BY_RANGE_URI, notes = "This API is used to get all the stock detail between a range of dates")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Stock detail selected successfully", response = StockDetailResponse.class) })
	@GetMapping(FETCH_STOCK_BY_RANGE_URI)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "HTTP_AUTH_TOKEN", value = "JWT token header", required = false, dataType = "String", paramType = "header") })
	public ResponseEntity<StockDetailResponse> getStockByRange(
			@RequestHeader(required = false, value = "HTTP_AUTH_TOKEN") String jwtToken,
			@ApiParam(name = "companyCode", value = "companyCode", required = true) @PathVariable(name = "companyCode", required = true) String companyCode,
			@ApiParam(name = "startDate", value = "startDate", required = true) @PathVariable(name = "startDate", required = true) String startDate,
			@ApiParam(name = "endDate", value = "endDate", required = true) @PathVariable(name = "endDate", required = true) String endDate) {
		log.info("Stock details service started");
		StockDetailResponse response = service.getStockByRange(companyCode, startDate, endDate);
		return ResponseEntity.ok(response);
	}

}
